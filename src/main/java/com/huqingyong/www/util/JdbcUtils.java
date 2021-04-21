package com.huqingyong.www.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource source;

    static {
        try {
            Properties pros=new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");

         /*   InputStream inputStream=ClassLoader.getSystemClassLoader().getResourceAsStream("resources/druid.properties");*/
            pros.load(is);
            source= DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        Connection  conn=source.getConnection();
        return conn;
    }

    public static void closeResource (Connection cont) {
        if (cont != null) {
            try {
                cont.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }


    public static void close (Connection cont, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        if (cont != null) {
            try {
                cont.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void close (Connection cont, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        if (cont != null) {
            try {
                cont.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
