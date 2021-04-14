package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.ActivityDao;
import com.huqingyong.www.dao.Impl.ActivityDaoImpl;
import com.huqingyong.www.dao.Impl.PageDaoImpl;
import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.service.ActivityService;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    ActivityDao activityDao=new ActivityDaoImpl();
    PageDao pageDao=new PageDaoImpl();
    @Override
    public void savingActivity(Activity activity) {
        activityDao.saveActivity(activity);
    }


    public Page queryActivityByPage(Integer pageNo, Integer pageSize, Integer sponsorId) throws ParseException {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.queryActivityPageTotalCount(sponsorId);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Activity> items=changeStatus(pageDao.queryActivityByPage(begin,pageSize,sponsorId));
        page.setItems(items);
        return page;
    }

    @Override
    public void updateActivity(Activity activity) {
        activityDao.updateActivity(activity);
    }

    @Override
    public void deleteActivity(Integer activityId) {
        activityDao.deleteActivity(activityId);
    }

    @Override
    public Integer queryActivityTime(Integer activityId) {
        return activityDao.getActivityTime(activityId);
    }

    @Override
    public List<Activity> changeStatus(List<Activity> list) throws ParseException {
        Iterator<Activity> iterator=list.iterator();
        while (iterator.hasNext()){
            //获取活动还有其一些属性
            Activity activity=iterator.next();
            Integer activityId=activity.getId();
            Integer managerId=activity.getManagerId();
            String startTime=activity.getActivityStartTime();
            String overTime=activity.getActivityOverTime();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos=new ParsePosition(0);

            Date DateTime1=sdf.parse(startTime);
            Date DateTime2=sdf.parse(overTime);
            Long startDateTime=DateTime1.getTime();
            Long overDateTime=DateTime2.getTime();
            Long nowTime=System.currentTimeMillis();
            if(managerId==null){
                activity.setActivityStatus("申请中");
                activityDao.changeStatus(activityId,"申请中");
            }
            if(managerId!=null){
                if(nowTime<startDateTime){
                    activity.setActivityStatus("待进行");
                    activityDao.changeStatus(activityId,"待进行");
                }
                if(nowTime>startDateTime&&nowTime<overDateTime){
                    activity.setActivityStatus("进行中");
                    activityDao.changeStatus(activityId,"进行中");
                }
                if(nowTime>overDateTime){
                    activity.setActivityStatus("已完结");
                    activityDao.changeStatus(activityId,"已完结");
                }
            }
        }
        return list;
    }

    @Override
    public Integer getActivityPeople(Integer activityId) {
        return activityDao.queryActivityPeople(activityId);
    }

    @Override
    public Integer getStudent(Integer activityId) {
        return pageDao.queryStudentTotalCount(activityId);
    }

    @Override
    public boolean weatherFull(Integer activityId) {
        if(getStudent(activityId)<getActivityPeople(activityId)){
            return false;
        }
       return true;
    }

    @Override
    public Page<Activity> showIndex(Integer pageNo, Integer pageSize, String weatherNull, String vagueType, String vagueName) throws ParseException {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.queryActivityAll(weatherNull,vagueType,vagueName);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Activity> items=changeStatus(pageDao.queryActivity(begin,pageSize,weatherNull,vagueType,vagueName));
        page.setItems(items);
        return page;
    }


}
