package com.huqingyong.www.contoller;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.service.ActivityService;
import com.huqingyong.www.service.impl.ActivityServiceImpl;
import com.huqingyong.www.util.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileServlet extends HttpServlet {
    ActivityService activityService=new ActivityServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Activity activity= new Activity();
        HttpSession session= req.getSession();
        activity.setSponsorId((Integer) session.getAttribute("sponsorId"));
        //先判断是否是多段数据
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //解析上传数据的工具类
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据。得到每一个表单项FileItem
                List<FileItem> list=servletFileUpload.parseRequest(req);
                //循环判断，每一个表单项，是普通类型，还是上传的文件
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        String name=fileItem.getFieldName();
                        String value=fileItem.getString("UTF-8");
                        //普通表单项
                        if("activityName".equals(name)){activity.setActivityName(value);}
                        if("activityType".equals(name)){activity.setActivityType(value);}
                        if("activityContext".equals(name)){activity.setActivityContext(value);}
                        if("activitySite".equals(name)){activity.setActivitySite(value);}
                        if("activityStartTime".equals(name)){activity.setActivityStartTime(value);}
                        if("activityOverTime".equals(name)){activity.setActivityOverTime(value);}
                        if("activityTime".equals(name)){activity.setActivityTime(WebUtils.parseInt(value,0));}
                        if("activityPeople".equals(name)){activity.setActivityPeople(WebUtils.parseInt(value,0));}
                    }
                    else{
                        //上传的文件
                        fileItem.write(new File("D:\\"+fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        activityService.savingActivity(activity);
        req.getRequestDispatcher("/pages/sponsor/release_success.jsp").forward(req, resp);
    }
}
