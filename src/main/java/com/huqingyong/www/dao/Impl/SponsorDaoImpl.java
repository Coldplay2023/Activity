package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.SponsorDao;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.util.JdbcUtils;
import com.huqingyong.www.util.WebUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SponsorDaoImpl implements SponsorDao {
    @Override
    public Sponsor querySponsor(String account) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Sponsor sponsor=new Sponsor();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_sponsor where account =?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            rs=ps.executeQuery();
            if(rs.next()) {
                sponsor.setId(rs.getInt("id"));
                sponsor.setAccount(rs.getString("account"));
                sponsor.setPassword(rs.getString("password"));
                sponsor.setClubName(rs.getString("clubName"));
                sponsor.setClubIntroduction(rs.getString("clubIntroduction"));
                sponsor.setPrincipalName(rs.getString("principalName"));
                sponsor.setPrincipalContact(rs.getString("principalContact"));
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return sponsor;
    }

    @Override
    public boolean identifySponsor(String account, String password,String whetherNull) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_sponsor where account =? and password=? and managerId is "+whetherNull ;
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public void savingSponsor(Sponsor sponsor) {
        Connection conn=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert t_sponsor (account,password,clubName,principalName,principalContact,clubIntroduction) " +
                    "values(?,?,?,?,?,?)";
            WebUtils.setSponsorValue(conn.prepareStatement(sql),sponsor).executeUpdate();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.closeResource(conn);
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_sponsor set account=? ,password=?, clubName=?, principalName=?,principalContact=?,clubIntroduction=?" +
                    " where id =?";
            ps=WebUtils.setSponsorValue(conn.prepareStatement(sql),sponsor);
            ps.setInt(7,sponsor.getId());
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

}
