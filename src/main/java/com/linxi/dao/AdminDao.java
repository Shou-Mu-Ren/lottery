package com.linxi.dao;

import com.linxi.bean.Ticket;
import com.linxi.bean.User;
import com.linxi.bean.Win;

import java.util.List;

public interface AdminDao {
    List<User> find(User user);
    void updateUser(Integer id, Integer money);
    List<Ticket> findTicket(Integer number, Integer winId);
    void updateTicket(Integer number, Integer winId);
    List<Win> winList();
    void updateWin(Integer winId, Integer number);
    Win win();
    boolean insertWin();
}
