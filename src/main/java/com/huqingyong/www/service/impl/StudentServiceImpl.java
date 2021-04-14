package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.Impl.StudentDaoImpl;
import com.huqingyong.www.dao.StudentDao;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.service.StudentService;


public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public boolean identifyStudent(String number, String password) {
        return  studentDao.identifyStudent(number,password);
    }

    @Override
    public boolean savingStudent(Student student) {
        if(studentDao.identifyStudent(student.getNumber(),student.getPassword()) ){
            return false;
        }
        studentDao.saveStudent(student);
        return true;
    }

    @Override
    public Student queryStudent(String number) {
        return studentDao.queryStudent(number);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public Integer getTime(String number) {
        return studentDao.queryStudent(number).getTime();
    }

    @Override
    public void updateTime(String number, Integer time) {
        studentDao.updateTime(number,time);
    }

    @Override
    public void joinActivity(Integer studentId, Integer activityId) {
        studentDao.insertStudent1(studentId,activityId);
    }

    @Override
    public boolean whetherJoin(Integer studentId, Integer activityId) {
        return studentDao.whetherJoin(studentId,activityId);
    }

}
