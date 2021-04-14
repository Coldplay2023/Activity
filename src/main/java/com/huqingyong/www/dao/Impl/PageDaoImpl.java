package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.PageDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.util.JdbcUtils;

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
        List<Activity> activities=new ArrayList<Activity>();

        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_activity where sponsorId=?  limit ? ,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,sponsorId);
            ps.setInt(2,begin);
            ps.setInt(3,pageSize);
            //预编译这个方法里面不能写sql语句
            rs=ps.executeQuery();
            while(rs.next()){
                Activity activity=new Activity();
                activity.setActivityName(rs.getString("activityName"));
                activity.setActivityType(rs.getString("activityType"));
                activity.setActivitySite(rs.getString("activitySite"));
                activity.setActivityStartTime(rs.getString("activityStartTime"));
                activity.setActivityOverTime(rs.getString("activityOverTime"));
                activity.setActivityTime(rs.getInt("activityTime"));
                activity.setActivityPeople(rs.getInt("activityPeople"));
                activity.setActivityContext(rs.getString("activityContext"));
                activity.setId(rs.getInt("id"));
                activity.setSponsorId((rs.getInt("sponsorId")));
                activity.setManagerId(rs.getInt("managerId"));
                activities.add(activity);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,sponsorId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
        List<Activity> activities=new ArrayList<Activity>();
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
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,begin);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();
            while(rs.next()){
                Activity activity=new Activity();
                activity.setActivityName(rs.getString("activityName"));
                activity.setActivityType(rs.getString("activityType"));
                activity.setActivitySite(rs.getString("activitySite"));
                activity.setActivityStartTime(rs.getString("activityStartTime"));
                activity.setActivityOverTime(rs.getString("activityOverTime"));
                activity.setActivityTime(rs.getInt("activityTime"));
                activity.setActivityPeople(rs.getInt("activityPeople"));
                activity.setActivityContext(rs.getString("activityContext"));
                activity.setId(rs.getInt("id"));
                activity.setSponsorId((rs.getInt("sponsorId")));
                activity.setManagerId(rs.getInt("managerId"));
                activities.add(activity);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
            //预编译这个方法里面不能写sql语句
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
        List<Sponsor> sponsors=new ArrayList<Sponsor>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_sponsor where managerId is null limit ? ,?";
            ps=conn.prepareStatement(sql);
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,begin);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();

            while(rs.next()){
                Sponsor sponsor=new Sponsor();
                sponsor.setId(rs.getInt("id"));
                sponsor.setAccount(rs.getString("account"));
                sponsor.setClubName(rs.getString("clubName"));
                sponsor.setClubIntroduction(rs.getString("clubIntroduction"));
                sponsor.setPrincipalName(rs.getString("principalName"));
                sponsor.setPrincipalContact(rs.getString("principalContact"));
                sponsors.add(sponsor);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
        Integer pageTotalCount=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select count(*) from t_sponsor where managerId is null";
            ps=conn.prepareStatement(sql);
            //预编译这个方法里面不能写sql语句
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,activityId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
        Integer pageTotalCount=null;
        List<Student> students=new ArrayList<Student>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select s.id,s.name,s.number,s.grade_academe from t_student s join t_relationship1 r" +
                    " where s.id=r.studentId and activityId=? limit ?,?";
            ps=conn.prepareStatement(sql);
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,activityId);
            ps.setInt(2,begin);
            ps.setInt(3,pageSize);
            rs=ps.executeQuery();
            while(rs.next()){
               Student student=new Student();
               student.setId(rs.getInt("id"));
               student.setName(rs.getString("name"));
               student.setNumber(rs.getString("number"));
               student.setGrade_academe(rs.getString("grade_academe"));
               students.add(student);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
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
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,activityId);
            ps.setInt(2,sponsorId);
            rs=ps.executeQuery();
            if(rs.next()){
                pageTotalCount=rs.getInt(1);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return pageTotalCount;
    }

    @Override
    public List<Student> queryStudentByPage(Integer begin, Integer pageSize, Integer activityId, Integer sponsorId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer pageTotalCount=null;
        List<Student> students=new ArrayList<Student>();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select s.id,s.name,s.number,s.grade_academe from t_student s join t_relationship2 r" +
                    " where s.id=r.studentId and activityId=? and sponsorId=? limit ?,?";
            ps=conn.prepareStatement(sql);
            //预编译这个方法里面不能写sql语句
            ps.setInt(1,activityId);
            ps.setInt(2,sponsorId);
            ps.setInt(3,begin);
            ps.setInt(4,pageSize);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setNumber(rs.getString("number"));
                student.setGrade_academe(rs.getString("grade_academe"));
                students.add(student);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return students;
    }
}
