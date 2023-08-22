package com.linxi.service.impl;

import com.linxi.bean.Ticket;
import com.linxi.bean.User;
import com.linxi.bean.Win;
import com.linxi.dao.UserDao;
import com.linxi.dao.impl.UserDaoImpl;
import com.linxi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDao dao = new UserDaoImpl();


    @Override
    public void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.setUserId(Integer.parseInt(req.getParameter("id")));
        ticket.setWin(0);
        ticket.setWinId(Integer.parseInt(req.getParameter("winId")));
        ticket.setNumber(Integer.parseInt(req.getParameter("number")));
        ticket.setMultiple(Integer.parseInt(req.getParameter("multiple")));
        dao.insertTicket(ticket);
        dao.updateUser(ticket.getUserId(),ticket.getMultiple()*10);
        req.getRequestDispatcher("buyPage").forward(req,resp);
    }

    @Override
    public void buyPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = dao.findUserById(id);
        List<Win> wins = dao.winList();
        req.setAttribute("user", user);
        req.setAttribute("win", wins.get(wins.size()-1));
        req.getRequestDispatcher("../buy.jsp").forward(req,resp);
    }

    @Override
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        if (user == null){
            Integer id = Integer.parseInt(req.getParameter("id"));
            user = dao.findUserById(id);
        }
        List<Ticket> tickets = dao.ticketList(user);
        List<Win> wins = dao.winList();
        req.setAttribute("user", user);
        req.setAttribute("tickets", tickets);
        req.setAttribute("wins", wins);
        req.getRequestDispatcher("../list.jsp").forward(req,resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(String.valueOf(req.getParameter("username")));
        user.setPassword(String.valueOf(req.getParameter("password")));
        List<User> users = dao.find(user);
        if(users.size() != 0){
            req.setAttribute("user",users.get(0));
            req.getRequestDispatcher("list").forward(req,resp);
        }else{
            req.setAttribute("info","登录失败,账号或密码错误");
            req.getRequestDispatcher("../login.jsp").forward(req,resp);
        }
    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(String.valueOf(req.getParameter("username")));
        user.setPassword(String.valueOf(req.getParameter("password")));
        String is = String.valueOf((req.getParameter("makePassword")));
        user.setMoney(1000);
        user.setRole(0);
        if(dao.insertUser(user) && is.equals(user.getPassword())){
            req.setAttribute("info","注册成功,请前往登录");
            req.getRequestDispatcher("../register.jsp").forward(req,resp);

        }else{
            req.setAttribute("info","注册失败,账号或密码格式错误");
            req.getRequestDispatcher("../register.jsp").forward(req,resp);
        }
    }
}
