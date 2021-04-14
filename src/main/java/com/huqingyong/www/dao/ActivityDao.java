package com.huqingyong.www.dao;

import com.huqingyong.www.po.Activity;


public interface ActivityDao {
    //发布活动
    void saveActivity(Activity activity);
    //不通过删除活动
    void deleteActivity(Integer activityId);
    //修改活动
    void updateActivity(Activity activity);
    //得到活动的时长
    Integer getActivityTime(Integer activityId);
    //更改活动的状态
    void changeStatus(Integer activityId,String status);
    //查询活动的已参加人数
    Integer queryActivityPeople(Integer activityId);

}
