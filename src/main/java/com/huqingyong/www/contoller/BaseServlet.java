package com.huqingyong.www.contoller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//第三层（重点：有共同代码抽象出来）,并且继承类也会继承下去。
public abstract class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一层：通过反射机制优化代码
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        /*String action ="list";*/
        try {
            //获取方法反射对象
            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this,req,resp) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
