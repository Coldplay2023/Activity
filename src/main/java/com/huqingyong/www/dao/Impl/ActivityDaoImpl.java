package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.ActivityDao;
import com.huqingyong.www.po.Activity;
import com.huqingyong.www.util.JdbcUtils;
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
            ps=conn.prepareStatement(sql);

            ps.setString(1,activity.getActivityName());
            ps.setString(2,activity.getActivityType());
            ps.setString(3,activity.getActivitySite());
            ps.setString(4,activity.getActivityStartTime());
            ps.setString(5,activity.getActivityOverTime());
            ps.setInt(6,activity.getActivityTime());
            ps.setInt(7,activity.getActivityPeople());
            ps.setString(8,activity.getActivityContext());
            ps.setInt(9,activity.getSponsorId());
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,null);
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
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();


        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,null);
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
            ps=conn.prepareStatement(sql);

            ps.setString(1,activity.getActivityName());
            ps.setString(2,activity.getActivityType());
            ps.setString(3,activity.getActivitySite());
            ps.setString(4,activity.getActivityStartTime());
            ps.setString(5,activity.getActivityOverTime());
            ps.setInt(6,activity.getActivityTime());
            ps.setInt(7,activity.getActivityPeople());
            ps.setString(8,activity.getActivityContext());
            ps.setInt(9,activity.getId());
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,null);
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
            //预编译这个方法里面不能写sql语句
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
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,null);
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
            //预编译这个方法里面不能写sql语句
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
