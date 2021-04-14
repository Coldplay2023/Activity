package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.ManagerDao;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDaoImpl implements ManagerDao {

    @Override
    public boolean identifyManager(String managerAccount, String managerPassword) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_manager where managerAccount=? and managerPassword=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,managerAccount);
            ps.setString(2,managerPassword);

            rs=ps.executeQuery();
            if(rs.next()) {
                return true;
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public Integer getManagerId(String managerAccount) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer managerId=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select id from t_manager where managerAccount=? ";
            ps=conn.prepareStatement(sql);
            ps.setString(1,managerAccount);

            rs=ps.executeQuery();
            if(rs.next()) {
                managerId=rs.getInt("id");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return managerId;
    }

    @Override
    public void updateActivityManagerId(Integer activityId,Integer managerId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_activity set managerId=? where id=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,managerId);
            ps.setInt(2,activityId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public void updateSponsorManagerId(Integer sponsorId,Integer managerId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_sponsor set managerId=? where id=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,managerId);
            ps.setInt(2,sponsorId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public void deleteActivity(Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_activity  where id=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,activityId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public void deleteSponsor(Integer sponsorId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_sponsor  where id=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,sponsorId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }
}
