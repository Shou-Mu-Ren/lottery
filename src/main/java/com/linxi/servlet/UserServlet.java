package com.linxi.servlet;


import com.linxi.bean.User;
import com.linxi.dao.UserDao;
import com.linxi.service.UserService;
import com.linxi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private static UserService userService= new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            String url = req.getRequestURI();
            String[] cmps = url.split("/");
            String methodName = cmps[cmps.length-1];
            Method method = getClass().getMethod(methodName,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            method.invoke(this,req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.buy(req,resp);
    }
    public void buyPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.buyPage(req,resp);
    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.list(req,resp);
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req,resp);
    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.register(req,resp);
    }

}
