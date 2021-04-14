package com.huqingyong.www.dao;

import com.huqingyong.www.dao.Impl.ActivityDaoImpl;
import com.huqingyong.www.po.Activity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {



    ActivityDao activityDao=new ActivityDaoImpl();
    @Test
    void saveActivity() {
        Activity activity=new Activity("志愿工大","理想志愿","教一316", "2021-04-01","2021-04-02",
                2,200,"申请中","拖地");
        activityDao.saveActivity(activity);
    }

    @Test
    void deleteActivity() {
        activityDao.deleteActivity(2);
    }

    @Test
    void updateActivity() {
        Activity activity=new Activity("服务工大","理想志愿","教一316", "2021-04-01","2021-04-02",
                2,200,"申请中","拖地");
        activityDao.updateActivity(activity);
    }

    @Test
    void getActivityTime() {
        System.out.println(activityDao.getActivityTime(3));
    }

    @Test
    void changeStatus() {
        activityDao.changeStatus(1,"已完结");
    }

    @Test
    void queryActivityPeople() {
        System.out.println(activityDao.queryActivityPeople(1));
    }
}