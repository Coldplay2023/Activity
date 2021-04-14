package com.huqingyong.www.dao;

import com.huqingyong.www.dao.Impl.PageDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageDaoTest {
    PageDao pageDao=new PageDaoImpl();
    @Test
    void queryActivityByPage() {
        System.out.println(pageDao.queryActivityByPage(1,5,1));
    }

    @Test
    void queryActivityPageTotalCount() {
        System.out.println(pageDao.queryActivityPageTotalCount(1));
    }

    @Test
    void queryActivity() {
        System.out.println(pageDao.queryActivity(0,4,"not null","理想","志愿"));
    }

    @Test
    void queryActivityAll() {
        System.out.println(pageDao.queryActivityAll("not null","理想","志愿"));
    }

    @Test
    void querySponsor() {
        System.out.println(pageDao.querySponsor(1,4));
    }

    @Test
    void querySponsorAll() {
        System.out.println(pageDao.querySponsorAll());
    }

    @Test
    void queryStudentTotalCount() {
        System.out.println(pageDao.queryStudentTotalCount(1));
    }

    @Test
    void queryStudentByPage() {
        System.out.println(pageDao.queryStudentByPage(3,4,2));
    }


}