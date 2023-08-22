package com.linxi.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.linxi.bean.Ticket;
import com.linxi.bean.User;
import com.linxi.bean.Win;
import com.linxi.dao.AdminDao;
import com.linxi.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class AdminDaoImpl implements AdminDao{
    private static JdbcTemplate tpl;
    static {
        try(InputStream is = UserDao.class.getClassLoader().getResourceAsStream("druid.properties")){
            Properties properties = new Properties();
            properties.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            tpl = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<User> find(User user){
        String sql = "select * from user where username=\'"+ user.getUsername()+"\' and password=\'"+user.getPassword() +"\'";
        List<User> users = tpl.query(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getInt("money"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        });
        return users;
    }

    @Override
    public void updateUser(Integer id, Integer money) {
        String sql = "update  user set money=money+"+money+" where id="+id;
        tpl.update(sql);
    }

    @Override
    public List<Ticket> findTicket(Integer number, Integer winId) {
        String sql = "select * from ticket where number="+ number +" and win_id="+winId;
        List<Ticket> tickets = tpl.query(sql, new RowMapper<Ticket>(){
            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setNumber(rs.getInt("number"));
                ticket.setMultiple(rs.getInt("multiple"));
                ticket.setWin(rs.getInt("win"));
                ticket.setWinId(rs.getInt("win_id"));
                return ticket;
            }
        });
        return tickets;

    }

    @Override
    public void updateTicket(Integer number, Integer winId) {
        String sql = "update  ticket set win=2 where number="+ number +" and win_id="+winId;
        tpl.update(sql);
        sql = "update  ticket set win=1 where number!="+ number +" and win_id="+winId;
        tpl.update(sql);
    }

    @Override
    public List<Win> winList() {
        String sql = "select * from win order by id";
        List<Win> wins = tpl.query(sql, new RowMapper<Win>(){
            @Override
            public Win mapRow(ResultSet rs, int rowNum) throws SQLException {
                Win win = new Win();
                win.setId(rs.getInt("id"));
                win.setRoll(rs.getInt("roll"));
                win.setNumber(rs.getInt("number"));
                win.setMoney(rs.getInt("money"));
                return win;
            }
        });
        return wins;
    }

    @Override
    public void updateWin(Integer winId, Integer number) {
        String sql = "update  win set roll=1, number="+number+" where id="+winId;
        tpl.update(sql);
    }

    @Override
    public Win win() {
        String sql = "select * from win where roll=0 ";
        List<Win> wins = tpl.query(sql, new RowMapper<Win>(){
            @Override
            public Win mapRow(ResultSet rs, int rowNum) throws SQLException {
                Win win = new Win();
                win.setId(rs.getInt("id"));
                win.setRoll(rs.getInt("roll"));
                win.setNumber(rs.getInt("number"));
                win.setMoney(rs.getInt("money"));
                return win;
            }
        });
        return wins.get(0);
    }

    @Override
    public boolean insertWin() {
        String sql = "insert into win(roll,money) values (?,?)";
        return tpl.update(sql,0,10) > 0;
    }
}
