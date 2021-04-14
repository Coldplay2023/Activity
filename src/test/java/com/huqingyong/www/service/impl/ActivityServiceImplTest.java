package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.Impl.PageDaoImpl;
import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.service.ActivityService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ActivityServiceImplTest {
    ActivityService activityService=new ActivityServiceImpl();
    PageDao pageDao=new PageDaoImpl();
    @Test
    void changeStatus() throws ParseException {
        activityService.changeStatus(pageDao.queryActivity(0,13,"not null","",""));
    }
    @Test
    void whetherFull(){
        System.out.println(activityService.weatherFull(1));
    }
}