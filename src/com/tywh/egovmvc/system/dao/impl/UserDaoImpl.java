package com.tywh.egovmvc.system.dao.impl;

import com.tywh.egovmvc.bean.User;
import com.tywh.egovmvc.system.dao.UserDao;
import com.tywh.egovmvc.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao{
    @Override
    public int insert(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into t_user(usercode,username,userpwd,orgtype,regdate) values(?,?,?,?,?)";
        int count = 0;
        try {
            conn = DbUtil.getConnection();
            System.out.println("UserDaoImpl------->" + conn);
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsercode());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getUserpwd());
            ps.setString(4,user.getOrgtype());
            ps.setString(5,user.getRegdate());
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("±£¥Ê”√ªß ß∞‹");
        } finally {
            DbUtil.close(null, ps, null);
        }
        return count;
    }
}
