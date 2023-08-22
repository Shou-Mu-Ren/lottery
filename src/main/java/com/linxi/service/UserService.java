package com.linxi.service;

import com.linxi.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {
    void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void buyPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
