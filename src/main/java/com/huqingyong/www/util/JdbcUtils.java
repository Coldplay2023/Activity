package com.huqingyong.www.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtils {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public JdbcUtils() {
    }


    public static Connection getConnection() throws SQLException {

        ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
        String url=bundle.getString("URL");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        return DriverManager.getConnection(url, user, password);


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
}
