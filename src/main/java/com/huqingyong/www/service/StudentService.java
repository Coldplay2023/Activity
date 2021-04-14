package com.huqingyong.www.service;

import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Student;

public interface StudentService {
    //验证学生的登录信息
    boolean identifyStudent(String userName,String password);
    //保存学生的业务
    boolean savingStudent(Student student);
    //查询学生的业务
    Student queryStudent(String number);
    //更新学生的业务
    void updateStudent(Student student);
    //获取学生原来时长
    Integer getTime(String number);
    //更新学生的时长
    void updateTime(String number,Integer time);
    //学生参加活动
    void joinActivity(Integer studentId,Integer activityId);
    //验证学生是否已经参加活动
    boolean whetherJoin(Integer studentId,Integer activityId);
}
