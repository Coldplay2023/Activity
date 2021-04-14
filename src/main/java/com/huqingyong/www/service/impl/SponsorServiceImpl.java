package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.Impl.PageDaoImpl;
import com.huqingyong.www.dao.Impl.SponsorDaoImpl;
import com.huqingyong.www.dao.Impl.StudentDaoImpl;
import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.dao.SponsorDao;
import com.huqingyong.www.dao.StudentDao;
import com.huqingyong.www.po.Page;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.service.SponsorService;

import java.util.List;

public class SponsorServiceImpl implements SponsorService {
    SponsorDao sponsorDao=new SponsorDaoImpl();
    PageDao pageDao=new PageDaoImpl();
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public boolean identifySponsor(String account, String password,String whetherNull) {
        if(sponsorDao.identifySponsor(account,password,whetherNull)){
            return true;
        }
        return false;
    }

    @Override
    public Sponsor querySponsor(String account) {
        Sponsor sponsor=sponsorDao.querySponsor(account);
        return sponsor;
    }

    @Override
    public boolean savingSponsor(Sponsor sponsor) {
        if(sponsorDao.identifySponsor(sponsor.getAccount(),sponsor.getPassword(),"not null")){
            return false;
        }
       sponsorDao.savingSponsor(sponsor);
        return true;
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
      sponsorDao.updateSponsor(sponsor);
    }

    @Override
    public Page<Student> queryStudent(Integer pageNo, Integer pageSize, Integer activityId) {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.queryStudentTotalCount(activityId);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Student> items=pageDao.queryStudentByPage(begin,pageSize,activityId);
        page.setItems(items);
        return page;
    }

    @Override
    public void insertStudent2(Integer studentId, Integer sponsorId, Integer activityId) {
        studentDao.insertStudent2(studentId,sponsorId,activityId);
    }

    @Override
    public void deleteStudent1(Integer studentId, Integer activityId) {
        studentDao.deleteStudent1(studentId,activityId);
    }

    @Override
    public Page<Student> queryStudent(Integer pageNo, Integer pageSize, Integer activityId, Integer sponsorId) {
        Page page=new Page();
        //求每一页的记录个数
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=pageDao.queryStudentTotalCount(activityId,sponsorId);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0) {pageTotal+=1;}
        page.setPageTotal(pageTotal);
        //设置开始的页码
        page.setPageNo(pageNo);
        //求每一页的记录内容
        Integer begin=(page.getPageNo()-1)*pageSize;
        List<Student> items=pageDao.queryStudentByPage(begin,pageSize,activityId,sponsorId);
        page.setItems(items);
        return page;
    }

    @Override
    public void deleteStudent2(Integer studentId, Integer sponsorId, Integer activityId) {
        studentDao.deleteStudent2(studentId,sponsorId,activityId);
    }


}
