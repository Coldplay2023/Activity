package com.huqingyong.www.dao;

public interface ManagerDao {
    //登录验证管理员
    boolean identifyManager(String managerAccount,String password);
    //获取管理员id
    Integer getManagerId(String managerAccount);
    //通过的给活动或主办方加上管理员Id
    void updateActivityManagerId(Integer activityId,Integer managerId);
    void updateSponsorManagerId(Integer sponsorId,Integer managerId);
    //不通过的话删除活动或者主办方
    void deleteActivity(Integer activityId);
    void deleteSponsor(Integer sponsorId);
}
