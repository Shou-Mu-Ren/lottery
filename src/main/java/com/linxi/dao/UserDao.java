package com.linxi.dao;

import com.linxi.bean.Ticket;
import com.linxi.bean.User;
import com.linxi.bean.Win;

import java.util.List;


public interface UserDao {
    List<User> find(User user);
    User findUserById(Integer id);
    boolean insertUser(User user);
    boolean updateUser(Integer id, Integer money);
    List<Ticket> ticketList(User user);
    boolean insertTicket(Ticket ticket);
    List<Win> winList();

}
