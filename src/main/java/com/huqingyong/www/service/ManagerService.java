package com.huqingyong.www.service;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Sponsor;

public interface ManagerService {
    //验证管理员信息
    boolean identifyManager(String mangerAccount,String ManagerPassword);
    //审核活动分页
    Page<Activity> queryActivityByPage(Integer pageNo,Integer pageSize,String weatherNull,String vagueType,String vagueName);
    //审核主办方分页
    Page<Sponsor> querySponsorByPage(Integer pageNo,Integer pageSize);
    //审核主办方
    void disagreeSponsor(Integer sponsorId);
    void agreeSponsor(Integer sponsorId,Integer managerId);
    //审核活动
    void disagreeActivity(Integer activityId);
    void  agreeActivity(Integer activityId,Integer managerId);
    //获取管理员的id
    Integer getManagerId(String managerAccount);
}
