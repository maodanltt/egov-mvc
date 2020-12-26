package com.tywh.egovmvc.system.service.impl;

import com.tywh.egovmvc.bean.User;
import com.tywh.egovmvc.system.dao.UserDao;
import com.tywh.egovmvc.system.dao.impl.UserDaoImpl;
import com.tywh.egovmvc.system.service.UserService;
import com.tywh.egovmvc.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public int save(User user) {

        int count = 0;
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            System.out.println("UserServiceImpl------->" + conn);
            conn.setAutoCommit(false);
            count = userDao.insert(user);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DbUtil.close(conn, null, null);
        }

        return count;
    }
}
