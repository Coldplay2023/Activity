package com.huqingyong.www.contoller;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.service.ActivityService;
import com.huqingyong.www.service.SponsorService;
import com.huqingyong.www.service.StudentService;
import com.huqingyong.www.service.impl.ActivityServiceImpl;
import com.huqingyong.www.service.impl.SponsorServiceImpl;
import com.huqingyong.www.service.impl.StudentServiceImpl;
import com.huqingyong.www.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SponsorServlet extends BaseServlet{

    SponsorService sponsorService=new SponsorServiceImpl();
    StudentService studentService=new StudentServiceImpl();
    ActivityService activityService=new ActivityServiceImpl();

    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String account=req.getParameter("account");
       String password=req.getParameter("password");
       HttpSession session=req.getSession();
       session.setAttribute("sponsorAccount",account);
       session.setAttribute("sponsorPassword",password);
       Integer sponsorId=(sponsorService.querySponsor(account)).getId();
       session.setAttribute("sponsorId",sponsorId);
       if(sponsorService.identifySponsor(account,password)){
           req.getRequestDispatcher("/pages/sponsor/sponsor.jsp").forward(req,resp);
       }
       else {
           req.setAttribute("msg","用户名或密码错误");
           req.setAttribute("account",account);
           req.getRequestDispatcher("/pages/user/sponsorLogin.jsp").forward(req,resp);
       }
    }
   //注册
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sponsor sponsor= WebUtils.copyParamTOBean(req.getParameterMap(),new Sponsor());
        HttpSession session= req.getSession();
        session.setAttribute("sponsorAccount",sponsor.getAccount());
        session.setAttribute("sponsorPassword",sponsor.getPassword());
        Integer sponsorId=(sponsorService.querySponsor(sponsor.getAccount())).getId();
        session.setAttribute("sponsorId",sponsorId);
        if(sponsorService.savingSponsor(sponsor)){
            req.getRequestDispatcher("/pages/sponsor/sponsor.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("msg", "用户名已经存在，请登录");
            req.getRequestDispatcher("/pages/user/sponsorRegist.jsp").forward(req, resp);
        }
    }
   //展示主办方信息
    protected void showSponsor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String account=(String) session.getAttribute("sponsorAccount");
        Sponsor sponsor=sponsorService.querySponsor(account);
        req.setAttribute("sponsor",sponsor);
        req.getRequestDispatcher("pages/sponsor/editSponsor.jsp").forward(req,resp);
    }
   //修改主办方
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sponsor sponsor= WebUtils.copyParamTOBean(req.getParameterMap(),new Sponsor());
        sponsorService.updateSponsor(sponsor);
        showSponsor(req,resp);
    }
    //中转处理提供时长还有审核学生的不同请求，然后转发
    protected void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bool=req.getParameter("bool");
        if("provideTime".equals(bool)){
            req.setAttribute("activityId",req.getParameter("activityId"));
            showStudentPT(req,resp);
        }
        if("checkStudent".equals(bool)){
            req.setAttribute("activityId",req.getParameter("activityId"));
            showStudentCS(req,resp);
        }

    }
    //展示提供时长的学生分页
    protected void showStudentPT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer activityId= WebUtils.parseInt((String) req.getAttribute("activityId"),0);
        HttpSession session= req.getSession();
        if(activityId!=0){
            session.setAttribute("activityId",activityId);
        }
        if(activityId==0){
            activityId=(Integer) session.getAttribute("activityId");
        }
        Integer sponsorId=(Integer) session.getAttribute("sponsorId");
        Page<Student> page=sponsorService.queryStudent(pageNo,pageSize,activityId,sponsorId);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/sponsor/provideTime.jsp").forward(req,resp);
    }

    //展示审核学生的学生分页
    protected void showStudentCS(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer activityId= WebUtils.parseInt((String) req.getAttribute("activityId"),0);
        HttpSession session= req.getSession();
        if(activityId!=0){
            session.setAttribute("activityId",activityId);
        }
        if(activityId==0){
            activityId=(Integer) session.getAttribute("activityId");
        }
        Page<Student> page=sponsorService.queryStudent(pageNo,pageSize,activityId);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/sponsor/examineStudent.jsp").forward(req,resp);
    }




    //同意学生
    protected void agree(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number=req.getParameter("number");
        Integer studentId=studentService.queryStudent(number).getId();
        HttpSession session= req.getSession();
        Integer sponsorId=(Integer) session.getAttribute("sponsorId");
        Integer activityId=(Integer)session.getAttribute("activityId");
        sponsorService.insertStudent2(studentId,sponsorId,activityId);
        sponsorService.deleteStudent1(studentId,activityId);
        showStudentCS(req,resp);
    }
   //不同意学生
    protected void disagree(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number=req.getParameter("number");
        Integer studentId=studentService.queryStudent(number).getId();
        HttpSession session= req.getSession();
        Integer activityId=(Integer)session.getAttribute("activityId");
        sponsorService.deleteStudent1(studentId,activityId);
        showStudentCS(req,resp);
    }
   //提供时长
    protected void provide(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Integer sponsorId=(Integer) session.getAttribute("sponsorId");
        Integer activityId=(Integer)session.getAttribute("activityId");
        String number=req.getParameter("number");
        Integer studentId=studentService.queryStudent(number).getId();
        Integer initialTime=studentService.getTime(number);
        Integer activityTime=activityService.queryActivityTime((Integer) session.getAttribute("activityId"));
        Integer time=initialTime+activityTime;
        studentService.updateTime(number,time);
        sponsorService.deleteStudent2(studentId,sponsorId,activityId);
        showStudentPT(req,resp);
    }

}
