package com.tywh.egovmvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws Exception{

        Connection conn = threadLocal.get();
        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/egov-mvc","root","root123");
            threadLocal.set(conn);
        }

        return conn;
    }

    public static void close(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }

        }
    }
}
