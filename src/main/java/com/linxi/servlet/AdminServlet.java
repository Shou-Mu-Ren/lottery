package com.linxi.servlet;

import com.linxi.service.AdminService;
import com.linxi.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet{

    private static AdminService adminService= new AdminServiceImpl();

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

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService.login(req,resp);
    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService.list(req,resp);
    }
    public void roll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService.roll(req,resp);
    }
    public void rollPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService.rollPage(req,resp);
    }

}
