package com.huqingyong.www.dao;

import com.huqingyong.www.dao.Impl.StudentDaoImpl;
import com.huqingyong.www.po.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoTest {

    StudentDao studentDao=new StudentDaoImpl();
    Student student=new Student("3120005000","1234567890Y","胡庆勇","2020-计算机学院");
    @Test
    void saveStudent() {
        studentDao.saveStudent(student);
    }

    @Test
    void queryStudent() {
        Student student=studentDao.queryStudent("3120005067");
        System.out.println(student);
    }

    @Test
    void updateStudent() {
        Student student=new Student("3120005067","1111111111","胡庆勇","2020-计算机学院");
        studentDao.updateStudent(student);
    }

    @Test
    void identifyStudent() {
        System.out.println(studentDao.identifyStudent("3120005067","11"));
    }

    @Test
    void updateTime() {
      studentDao.updateTime("3120005067",60);
    }

    @Test
    void insertStudent2() {
        studentDao.insertStudent2(1,1,1);
    }

    @Test
    void deleteStudent2() {
        studentDao.deleteStudent2(1,1,1);
    }

    @Test
    void deleteStudent1() {
      studentDao.deleteStudent1(1,1);
    }

    @Test
    void insertStudent1() {
     studentDao.insertStudent1(1,1);
    }
}