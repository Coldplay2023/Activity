package com.huqingyong.www.dao;

import com.huqingyong.www.po.Student;

public interface StudentDao {

    //注册存学生
    void saveStudent(Student student);
    //登录验证学生
    boolean identifyStudent(String number,String password);
    //查询学生个人信息
    Student queryStudent(String number);
    //修改学生个人信息
    void updateStudent(Student student);
    //更新学生的时长
    void updateTime(String number,Integer time);
    //把学生加入关系表2(审核同意)
    void insertStudent2(Integer studentId,Integer sponsorId,Integer activityId);
    //将学生从关系表2删除
    void deleteStudent2(Integer studentId,Integer sponsorId,Integer activityId);
    //将学生从关系表1删除
    void deleteStudent1(Integer studentId,Integer activityId);
    //把学生加入关系表1
    void insertStudent1(Integer studentId,Integer activityId);
    //验证学生是否已经参加活动
    boolean whetherJoin(Integer studentId,Integer activityId);

}
