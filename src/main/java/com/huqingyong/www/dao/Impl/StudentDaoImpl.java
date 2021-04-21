package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.StudentDao;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao{

    @Override
    public void saveStudent(Student student) {
        Connection conn=null;

        try {
            QueryRunner runner=new QueryRunner();
            conn=JdbcUtils.getConnection();
            String sql="insert into t_student (number,password,name,grade_academe) values(?,?,?,?)";
            runner.update(conn,sql,student.getNumber(),student.getPassword(),student.getName(),student.getGrade_academe());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.closeResource(conn);
        }
    }

    @Override
    public Student queryStudent(String number) {
        Connection conn=null;
        Student student=null;
        try {
            QueryRunner runner=new QueryRunner();
            conn=JdbcUtils.getConnection();
            String sql="select * from t_student where number =?";
            BeanHandler<Student> handler=new BeanHandler<>(Student.class);
            student=runner.query(conn,sql,handler,number);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.closeResource(conn);
        }
        return student;
    }


    @Override
    public void updateStudent(Student student) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_student set number=? ,password=?, name=?, grade_academe=? where number =?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,student.getNumber());
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getName());
            ps.setString(4,student.getGrade_academe());
            ps.setString(5,student.getNumber());
            ps.executeUpdate();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public boolean identifyStudent(String number, String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_student where number =?&&password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,number);
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
    public void updateTime(String number,Integer time) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_student set time=? where number=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,time);
            ps.setString(2,number);
            ps.executeUpdate();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }




    @Override
    public void insertStudent1(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert t_relationship1 (studentId,activityId) values(?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
            ps.setInt(2,activityId);
            ps.executeUpdate();


        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public boolean whetherJoin(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_relationship1 where studentId =? and activityId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,studentId);
            ps.setInt(2,activityId);

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
    public void insertStudent2(Integer studentId, Integer sponsorId,Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert t_relationship2 (studentId,sponsorId,activityId) values(?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
            ps.setInt(2,sponsorId);
            ps.setInt(3,activityId);
            ps.executeUpdate();


        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public void deleteStudent1(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_relationship1 where studentId=? and activityId=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
            ps.setInt(2,activityId);
            ps.executeUpdate();


        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public void deleteStudent2(Integer studentId, Integer sponsorId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_relationship2 where studentId=? and activityId=? and sponsorId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,studentId);
            ps.setInt(2,activityId);
            ps.setInt(3,sponsorId);
            ps.executeUpdate();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

}
