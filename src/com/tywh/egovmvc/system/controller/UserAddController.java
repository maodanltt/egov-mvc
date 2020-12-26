package com.tywh.egovmvc.system.controller;

import com.tywh.egovmvc.bean.User;
import com.tywh.egovmvc.system.service.UserService;
import com.tywh.egovmvc.system.service.impl.UserServiceImpl;
import com.tywh.egovmvc.utils.Const;
import com.tywh.egovmvc.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UserAddController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("GB18030");
        User user = new User();
        user.setUsercode(request.getParameter("usercode"));
        user.setUsername(request.getParameter("username"));
        user.setUserpwd(request.getParameter("userpwd"));
        user.setOrgtype(request.getParameter("orgtype"));
        user.setRegdate(DateUtil.format(new Date(), Const.DATE_PATTERN));
        int count = 0;
        count = userService.save(user);

        if (count == 1) {
            response.sendRedirect("/system/user.html");
        }

    }
}
