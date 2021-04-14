package com.huqingyong.www.service;

import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;

public interface SponsorService {
    //验证主办方的登录信息
    boolean identifySponsor(String account,String password);
    //查询主办方
    Sponsor querySponsor(String account);
    //注册保存主办方
    boolean savingSponsor(Sponsor sponsor);
    //更新主办方的信息
    void updateSponsor(Sponsor sponsor);
    //审核学生分页
    Page<Student> queryStudent(Integer pageNo,Integer pageSize,Integer activityId);
    //同意保存学生、主办方、活动信息到关系表2
    void insertStudent2(Integer studentId,Integer sponsorId,Integer activityId);
    //不同意从关系表1删除学生
    void deleteStudent1(Integer studentId,Integer activityId);
    //发放时长学生分页
    Page<Student> queryStudent(Integer pageNo,Integer pageSize,Integer activityId,Integer sponsorId);
    //发放时长后从关系表2删除学生
    void deleteStudent2(Integer studentId,Integer sponsorId,Integer activityId);

}
