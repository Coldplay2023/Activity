package com.huqingyong.www.contoller;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.service.ActivityService;
import com.huqingyong.www.service.StudentService;
import com.huqingyong.www.service.impl.ActivityServiceImpl;
import com.huqingyong.www.service.impl.StudentServiceImpl;
import com.huqingyong.www.util.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ActivityServlet extends BaseServlet{
    ActivityService activityService=new ActivityServiceImpl();
    StudentService studentService=new StudentServiceImpl();
    //发布活动
    protected void releaseActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    //主办方查看活动
    protected void queryActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Integer sponsorId=(Integer) session.getAttribute("sponsorId");
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Activity> page= null;
        try {
            page = activityService.queryActivityByPage(pageNo,pageSize,sponsorId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.setAttribute("page",page);
        String method=req.getParameter("method");
        if(method!=null){
            session.setAttribute("method",method);
        }
        method=(String) session.getAttribute("method");
        if("editActivity".equals(method)){
            req.getRequestDispatcher("/pages/sponsor/editActivity.jsp").forward(req, resp);
        }
        if("checkStudent".equals(method)){
            req.setAttribute("msg","审核学生");
            req.getRequestDispatcher("/pages/sponsor/activity.jsp").forward(req,resp);
        }
        if("provideTime".equals(method)){
            req.setAttribute("bool","provideTime");
            req.setAttribute("msg","发放时长");
            req.getRequestDispatcher("/pages/sponsor/activity.jsp").forward(req,resp);
        }
    }
    //更新活动
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Activity activity= WebUtils.copyParamTOBean(req.getParameterMap(),new Activity());
        HttpSession session=req.getSession();
        Integer sponsorId=(Integer) session.getAttribute("sponsorId");
        activity.setSponsorId(sponsorId);
        activityService.updateActivity(activity);
        queryActivity(req,resp);
    }
    //首页展示活动
    protected void showIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
         Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
         Integer pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        try {
            Page<Activity> page=activityService.showIndex(pageNo,pageSize,"not null",vagueType,vagueName);
            req.setAttribute("page",page);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/pages/index/index.jsp").forward(req,resp);
    }

    //学生参加活动
    protected void join(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session=req.getSession();
        Integer studentId=(Integer) session.getAttribute("studentId");
        Integer activityId=WebUtils.parseInt(req.getParameter("activityId"),0);
        req.setAttribute("activityName",req.getParameter("activityName"));
        if (activityService.weatherFull(activityId)){
            req.setAttribute("msg","活动人数已满");
            req.setAttribute("msg2","活动已满");
        }
        if(studentService.whetherJoin(studentId,activityId)){
            req.setAttribute("msg","你已经参加过这个活动");
            req.setAttribute("msg1","已经");
        }
        else{
            studentService.joinActivity(studentId,activityId);
            req.setAttribute("msg","报名成功");
            req.setAttribute("msg1","刚刚");
        }
       showIndex(req,resp);
    }
   //删除活动
    protected void deleteActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer activityId=WebUtils.parseInt(req.getParameter("activityId"),0);
        activityService.deleteActivity(activityId);
        queryActivity(req,resp);
    }


}
