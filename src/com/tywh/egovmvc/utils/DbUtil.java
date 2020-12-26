package com.tywh.egovmvc.utils;

import java.sql.*;

public class DbUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws Exception{

        Connection conn = threadLocal.get();
        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/egov_mvc","root","root123");
            threadLocal.set(conn);
        }

        return conn;
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
