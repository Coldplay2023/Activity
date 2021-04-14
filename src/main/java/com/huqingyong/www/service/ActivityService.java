package com.huqingyong.www.service;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;

import java.text.ParseException;
import java.util.List;

public interface ActivityService {
    //保存活动
    void savingActivity(Activity activity);
    //主办方查看活动分页
    Page queryActivityByPage(Integer pageNo, Integer pageSize, Integer sponsorId ) throws ParseException;
    //修改活动
    void updateActivity(Activity activity);
    //删除活动
    void deleteActivity(Integer activityId);
    //查询活动的时间
    Integer queryActivityTime(Integer activityId);
    //修改活动的状态
    List<Activity> changeStatus(List<Activity> list) throws ParseException;
    //查询活动人数上限
    Integer getActivityPeople(Integer activityId);
    //查询活动已经参加的人数
    Integer getStudent(Integer activityId);
    //验证活动人数是否已经满了
    boolean weatherFull(Integer activityId);
    //展示首页的活动
    Page<Activity> showIndex(Integer pageNo, Integer pageSize,String weatherNull,String vagueType,String vagueName) throws ParseException;
}
