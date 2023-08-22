package com.linxi.service.impl;

import com.linxi.bean.Ticket;
import com.linxi.bean.User;
import com.linxi.bean.Win;
import com.linxi.dao.AdminDao;
import com.linxi.dao.impl.AdminDaoImpl;
import com.linxi.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AdminServiceImpl implements AdminService {
    private static AdminDao dao = new AdminDaoImpl();
    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(String.valueOf(req.getParameter("username")));
        user.setPassword(String.valueOf(req.getParameter("password")));
        List<User> users = dao.find(user);
        if(users.size() != 0 && users.get(0).getRole()==1){
            req.setAttribute("user",users.get(0));
            req.getRequestDispatcher("list").forward(req,resp);
        }else{
            req.setAttribute("info","登录失败,账号或密码错误");
            req.getRequestDispatcher("../roll/login.jsp").forward(req,resp);
        }
    }

    @Override
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Win> wins = dao.winList();
        req.setAttribute("wins", wins);
        req.getRequestDispatcher("../roll/list.jsp").forward(req,resp);
    }

    @Override
    public void roll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer winId = Integer.parseInt(req.getParameter("winId"));
        Random r = new Random();
        Integer number = r.nextInt(5)+1;
        dao.updateWin(winId, number);
        dao.updateTicket(number, winId);
        List<Ticket> tickets = dao.findTicket(number, winId);
        for(Ticket ticket : tickets){
            dao.updateUser(ticket.getUserId(),ticket.getMultiple()*ticket.getMultiple()*10);
        }
        dao.insertWin();
        req.getRequestDispatcher("../roll/list.jsp").forward(req,resp);
    }

    @Override
    public void rollPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Win win = dao.win();
        req.setAttribute("win", win);
        req.getRequestDispatcher("../roll/roll.jsp").forward(req,resp);
    }

}
