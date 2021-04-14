package com.huqingyong.www.dao;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;

import java.util.List;

public interface PageDao {
    //活动分页
    List<Activity> queryActivityByPage(Integer begin, Integer pageSize,Integer sponsorId);
    Integer queryActivityPageTotalCount(Integer sponsorId);
    //审核活动分页/首页展示活动分页（管理员id是否为空来区分）
    List<Activity> queryActivity(Integer begin, Integer pageSize,String weatherNull,String vagueType,String vagueName);
    Integer queryActivityAll(String weatherNull,String vagueType,String vagueName);
    //审核主办方分页
    List<Sponsor> querySponsor(Integer begin, Integer pageSize);
    Integer querySponsorAll();
    //审核学生分页
    Integer queryStudentTotalCount(Integer activityId);
    List<Student> queryStudentByPage(Integer begin,Integer pageSize,Integer activityId);
    //发放时长学生分页
    Integer queryStudentTotalCount(Integer activityId,Integer sponsorId);
    List<Student> queryStudentByPage(Integer begin,Integer pageSize,Integer activityId,Integer sponsorId);
}
