package com.huqingyong.www.dao.Impl;

import com.huqingyong.www.dao.StudentDao;
import com.huqingyong.www.po.Student;
import com.huqingyong.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDaoImpl implements StudentDao{

    @Override
    public void saveStudent(Student student) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert into t_student (number,password,name,grade_academe) values(?,?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setString(1,student.getNumber());
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getName());
            ps.setString(4,student.getGrade_academe());
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();
            System.out.println("插入成功");

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public Student queryStudent(String number) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=new Student();
        try {
            conn= JdbcUtils.getConnection();
            String sql="select * from t_student where number =?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,number);

            rs=ps.executeQuery();
            if(rs.next()) {
                student.setNumber(number);
                student.setName(rs.getString("name"));
                student.setGrade_academe(rs.getString("grade_academe"));
                student.setPassword(rs.getString("password"));
                student.setTime(rs.getInt("time"));
                student.setId(rs.getInt("id"));
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
       return student;
    }


    @Override
    public void updateStudent(Student student) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_student set number=? ,password=?, name=?, grade_academe=? where number =?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,student.getNumber());
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getName());
            ps.setString(4,student.getGrade_academe());
            ps.setString(5,student.getNumber());

            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public boolean identifyStudent(String number, String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=new Student();
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


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public void updateTime(String number,Integer time) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="update t_student set time=? where number=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,time);
            ps.setString(2,number);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }




    @Override
    public void insertStudent1(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert t_relationship1 (studentId,activityId) values(?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
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
    public boolean whetherJoin(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=new Student();
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


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public void insertStudent2(Integer studentId, Integer sponsorId,Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="insert t_relationship2 (studentId,sponsorId,activityId) values(?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
            ps.setInt(2,sponsorId);
            ps.setInt(3,activityId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

    @Override
    public void deleteStudent1(Integer studentId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_relationship1 where studentId=? and activityId=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
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
    public void deleteStudent2(Integer studentId, Integer sponsorId, Integer activityId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtils.getConnection();
            String sql="delete from t_relationship2 where studentId=? and activityId=? and sponsorId=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,studentId);
            ps.setInt(2,activityId);
            ps.setInt(3,sponsorId);
            //预编译这个方法里面不能写sql语句
            ps.executeUpdate();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
    }

}
