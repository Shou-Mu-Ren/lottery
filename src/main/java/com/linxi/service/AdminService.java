package com.linxi.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AdminService {
    void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void roll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void rollPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
