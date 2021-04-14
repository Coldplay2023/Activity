package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.AnnouncementDao;
import com.huqingyong.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnnouncementDaoImpl implements AnnouncementDao {

    @Override
    public void update(String context) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_announcement set context=? ";
            ps=conn.prepareStatement(sql);

            ps.setString(1,context);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,null);
        }
    }



    @Override
    public String queryContext() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String context=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select context from t_announcement t_annoucement";
            ps=conn.prepareStatement(sql);
            //预编译这个方法里面不能写sql语句
            rs=ps.executeQuery();
            if(rs.next()){
                context=rs.getString("context");
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return context;
    }


}
