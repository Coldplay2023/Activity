package com.huqingyong.www.contoller;

import com.huqingyong.www.service.AnnouncementService;
import com.huqingyong.www.service.impl.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnnouncementServlet extends BaseServlet {

    AnnouncementService announcementService=new AnnouncementServiceImpl();

    protected void showAnnouncement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String context=announcementService.checkAnnouncement();
        String people=req.getParameter("people");
        if(people==null){people="manager";}
        req.setAttribute("context",context);

        if("student".equals(people)){
            req.getRequestDispatcher("/pages/student/studentAnnouncement.jsp").forward(req,resp);
        }
        if("sponsor".equals(people)){
            req.getRequestDispatcher("/pages/sponsor/sponsorAnnouncement.jsp").forward(req,resp);
        }
        if("manager".equals(people)){
            req.getRequestDispatcher("/pages/manager/announcement.jsp").forward(req,resp);
        }

    }

    protected void updateAnnouncement(HttpServletRequest req, HttpServletResponse resp)  {
        String bool=req.getParameter("bool");

        if("delete".equals(bool)){
            announcementService.updateAnnouncement(null);
        }
        if("update".equals(bool)){
            String context=req.getParameter("context");
            announcementService.updateAnnouncement(context);
        }
        try {
            showAnnouncement(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
