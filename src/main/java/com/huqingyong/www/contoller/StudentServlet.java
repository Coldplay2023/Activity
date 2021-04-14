package com.huqingyong.www.contoller;

import com.huqingyong.www.po.Student;
import com.huqingyong.www.service.ActivityService;
import com.huqingyong.www.service.StudentService;
import com.huqingyong.www.service.impl.ActivityServiceImpl;
import com.huqingyong.www.service.impl.StudentServiceImpl;
import com.huqingyong.www.util.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StudentServlet extends BaseServlet{

    StudentService studentService=new StudentServiceImpl();
    ActivityService activityService=new ActivityServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String number=req.getParameter("number");
          String password=req.getParameter("password");
          HttpSession session= req.getSession();
          session.setAttribute("number",number);
          session.setAttribute("studentId",studentService.queryStudent(number).getId());
          if(studentService.identifyStudent(number,password)){
              req.getRequestDispatcher("/pages/index/welcome.jsp").forward(req, resp);
          }
          else{
              req.setAttribute("msg", "用户名或密码错误");
              req.getRequestDispatcher("/pages/user/userLogin.jsp").forward(req, resp);
          }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Student student=WebUtils.copyParamTOBean(req.getParameterMap(),new Student());
        if(studentService.savingStudent(student)){
            HttpSession session= req.getSession();
            session.setAttribute("number",student.getNumber());
            session.setAttribute("studentId",studentService.queryStudent(student.getNumber()).getId());
            req.getRequestDispatcher("/pages/index/welcome.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("msg", "用户名已经存在，请登录");
            req.getRequestDispatcher("/pages/user/userRegister.jsp").forward(req, resp);
        }
    }

    protected void showStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session= req.getSession();
        String number= (String) session.getAttribute("number");
       Student student=studentService.queryStudent(number);
       req.setAttribute("student",student);
       req.getRequestDispatcher("/pages/student/editStudentInformation.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Student student=WebUtils.copyParamTOBean(req.getParameterMap(),new Student());
        studentService.updateStudent(student);
        showStudent(req,resp);
    }

    protected void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session= req.getSession();
        String number= (String) session.getAttribute("number");
        Student student=studentService.queryStudent(number);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/pages/student/checkStudentInformation.jsp").forward(req,resp);
    }



}
