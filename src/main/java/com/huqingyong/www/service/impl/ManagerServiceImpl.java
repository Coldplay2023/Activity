package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.Impl.ManagerDaoImpl;
import com.huqingyong.www.dao.Impl.PageDaoImpl;
import com.huqingyong.www.dao.ManagerDao;
import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao=new ManagerDaoImpl();
    PageDao pageDao=new PageDaoImpl();
    @Override
    public boolean identifyManager(String mangerAccount, String ManagerPassword) {
        return managerDao.identifyManager(mangerAccount,ManagerPassword);
    }

    @Override
    public Page<Activity> queryActivityByPage(Integer pageNo, Integer pageSize,String weatherNull,String vagueType,String vagueName) {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.queryActivityAll(weatherNull,vagueType,vagueName);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Activity> items=pageDao.queryActivity(begin, pageSize,weatherNull,vagueType,vagueName);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Sponsor> querySponsorByPage(Integer pageNo, Integer pageSize) {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.querySponsorAll();
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Sponsor> items=pageDao.querySponsor(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public void disagreeSponsor(Integer sponsorId) {
        managerDao.deleteSponsor(sponsorId);
    }

    @Override
    public void agreeSponsor(Integer sponsorId, Integer managerId) {
       managerDao.updateSponsorManagerId(sponsorId,managerId);
    }

    @Override
    public void disagreeActivity(Integer activityId) {
       managerDao.deleteActivity(activityId);
    }

    @Override
    public void agreeActivity(Integer activityId, Integer managerId) {
       managerDao.updateActivityManagerId(activityId,managerId);
    }

    @Override
    public Integer getManagerId(String managerAccount) {
        return managerDao.getManagerId(managerAccount);
    }


}
