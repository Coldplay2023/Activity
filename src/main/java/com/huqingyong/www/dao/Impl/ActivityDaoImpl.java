package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.ActivityDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.util.JdbcUtils;
import com.huqingyong.www.util.WebUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ActivityDaoImpl implements ActivityDao {
    @Override
    public void saveActivity(Activity activity) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert into t_activity (activityName,activityType, activitySite, " +
                    "activityStartTime,activityOverTime ,activityTime,activityPeople, " +
                    "activityContext,sponsorId) " +
                    "values(?,?,?,?,?,?,?,?,?)";
            ps= WebUtils.setActivityValue(conn.prepareStatement(sql),activity);
            ps.executeUpdate();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public void deleteActivity(Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_activity where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            ps.executeUpdate();


        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public void updateActivity(Activity activity) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_activity set activityName=?,activityType=?, activitySite=?,ActivityStartTime=? ," +
                    "ActivityOverTime=?,activityTime=?,activityPeople=?, activityContext=? where id=?" ;
            ps= WebUtils.setActivityValue(conn.prepareStatement(sql),activity);
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public Integer getActivityTime(Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer activityTime=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select activityTime from t_activity where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            rs=ps.executeQuery();
            if(rs.next()){
                activityTime=rs.getInt("activityTime");
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return activityTime;
    }

    @Override
    public void changeStatus(Integer activityId, String status) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_activity set activityStatus=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,status);
            ps.setInt(2,activityId);
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public Integer queryActivityPeople(Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer activityPeople=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select activityPeople from t_activity where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,activityId);
            rs=ps.executeQuery();
            if(rs.next()){
                activityPeople=rs.getInt("activityPeople");
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return activityPeople;
    }


}
