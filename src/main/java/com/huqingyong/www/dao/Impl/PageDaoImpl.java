package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.util.JdbcUtils;
import com.huqingyong.www.util.WebUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PageDaoImpl implements PageDao {

    public List<Activity> queryActivityByPage(Integer begin, Integer pageSize,Integer sponsorId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Activity> activities=new ArrayList<>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_activity where sponsorId=?  limit ? ,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,sponsorId);
            ps.setInt(2,begin);
            ps.setInt(3,pageSize);
            rs=ps.executeQuery();
            activities= WebUtils.activityList(rs);
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return activities;
    }

    @Override
    public Integer queryActivityPageTotalCount(Integer sponsorId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_activity where sponsorId=? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,sponsorId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public List<Activity> queryActivity(Integer begin, Integer pageSize,String whetherNull,String vagueType,String vagueName) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Activity> activities=new ArrayList<>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_activity where managerId is "+whetherNull;
                if (vagueName!=null) {
                    sql += " and (activityName like '%" + vagueName + "%'"+" or  activityName like '" + vagueName + "%'"+" or activityName like '%" + vagueName + "')";
                }
                if (vagueType!=null) {
                    sql += " and (activityType  like '%" + vagueType + "%'"+" or activityType like '" + vagueType + "%'"+" or activityType  like '%" + vagueType + "')";
                }
                sql+=" limit ?,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,begin);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();
            activities=WebUtils.activityList(rs);

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return activities;
    }

    @Override
    public Integer queryActivityAll(String whetherNull,String vagueType,String vagueName) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_activity where managerId is "+whetherNull;
                if (vagueName!=null) {
                    sql += " and (activityName like '%" + vagueName + "%'"+" or  activityName like '" + vagueName + "%'"+" or activityName like '%" + vagueName + "')";
                }
                if (vagueType!=null) {
                    sql += " and (activityType  like '%" + vagueType + "%'"+" or activityType like '" + vagueType + "%'"+" or activityType  like '%" + vagueType + "')";
                }
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public List<Sponsor> querySponsor(Integer begin, Integer pageSize) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Sponsor> sponsors=new ArrayList<>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_sponsor where managerId is null limit ? ,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,begin);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();
            sponsors=WebUtils.sponsorList(rs);

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return sponsors;
    }

    @Override
    public Integer querySponsorAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount = null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_sponsor where managerId is null";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public Integer queryStudentTotalCount(Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_relationship1 where activityId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public List<Student> queryStudentByPage(Integer begin, Integer pageSize, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Student> students=new ArrayList<>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select s.id,s.name,s.number,s.grade_academe from t_student s join t_relationship1 r" +
                    " where s.id=r.studentId and activityId=? limit ?,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            ps.setInt(2,begin);
            ps.setInt(3,pageSize);
            rs=ps.executeQuery();
            students=WebUtils.studentList(rs);

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return students;
    }

    @Override
    public Integer queryStudentTotalCount(Integer activityId, Integer sponsorId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_relationship2 where activityId=? and sponsorId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            ps.setInt(2,sponsorId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public List<Student> queryStudentByPage(Integer begin, Integer pageSize, Integer activityId, Integer sponsorId) {
        Connection conn=null;
        List<Student> students=new ArrayList<>();
        try {
            QueryRunner runner=new QueryRunner();
            conn= JdbcUtils.getConnection();
            String sql="select s.id,s.name,s.number,s.grade_academe from t_student s join t_relationship2 r" +
                    " where s.id=r.studentId and activityId=? and sponsorId=? limit ?,?";
            BeanListHandler<Student> beanListHandler=new BeanListHandler<>(Student.class);
            students=runner.query(conn,sql,beanListHandler,activityId,sponsorId,begin,pageSize);

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.closeResource(conn);
        }
        return students;
    }


}
