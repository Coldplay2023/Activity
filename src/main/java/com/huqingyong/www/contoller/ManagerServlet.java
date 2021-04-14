package com.huqingyong.www.contoller;

import com.huqingyong.www.po.*;
import com.huqingyong.www.service.ManagerService;
import com.huqingyong.www.service.StudentService;
import com.huqingyong.www.service.impl.ManagerServiceImpl;
import com.huqingyong.www.service.impl.StudentServiceImpl;
import com.huqingyong.www.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerServlet extends BaseServlet{

    ManagerService managerService=new ManagerServiceImpl();
    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager= WebUtils.copyParamTOBean(req.getParameterMap(),new Manager());
        HttpSession session=req.getSession();
        session.setAttribute("managerId",managerService.getManagerId(manager.getManagerAccount()));
        if(managerService.identifyManager(manager.getManagerAccount(),manager.getManagerPassword())){
            req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("msg","账号或密码出错");
            req.getRequestDispatcher("/pages/user/managerLogin.jsp").forward(req,resp);
        }
    }
   //审核主办方分页
    protected void checkSponsor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Sponsor> page=managerService.querySponsorByPage(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/examineSponsor.jsp").forward(req,resp);
    }
   //审核活动分页
    protected void checkActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String vagueName=req.getParameter("vagueName");
        String vagueType=req.getParameter("vagueType");
        HttpSession session=req.getSession();
        if(vagueName!=null){
            session.setAttribute("vagueName",vagueName);
        }
        if(vagueType!=null){
           session.setAttribute("vagueType",vagueType);
        }
        vagueName=(String) session.getAttribute("vagueName");
        vagueType=(String) session.getAttribute("vagueType");
        Page<Activity> page=managerService.queryActivityByPage(pageNo,pageSize,"null",vagueType,vagueName);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/examineActivity.jsp").forward(req,resp);
    }
   //不通过主办方
    protected void disagreeSponsor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Integer sponsorId=WebUtils.parseInt(req.getParameter("sponsorId"),0);
       managerService.disagreeSponsor(sponsorId);
       checkSponsor(req,resp);

    }
    //通过主办方
    protected void agreeSponsor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Integer managerId=(Integer) session.getAttribute("managerId");
        Integer sponsorId=WebUtils.parseInt(req.getParameter("sponsorId"),0);
        managerService.agreeSponsor(sponsorId,managerId);
        checkSponsor(req,resp);
    }
    //不通过活动
    protected void disagreeActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer activityId=WebUtils.parseInt(req.getParameter("activityId"),0);
        managerService.disagreeActivity(activityId);
        checkActivity(req,resp);
    }
    //通过活动
    protected void  agreeActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Integer managerId=(Integer) session.getAttribute("managerId");
        Integer activityId=WebUtils.parseInt(req.getParameter("activityId"),0);
        managerService.agreeActivity(activityId,managerId);
        checkActivity(req,resp);
    }

}
