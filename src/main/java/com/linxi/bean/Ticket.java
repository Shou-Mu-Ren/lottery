package com.linxi.bean;

public class Ticket {
    Integer id;
    Integer userId;
    Integer number;
    Integer multiple;
    //0未开奖 1未中奖 2中奖
    Integer win;
    Integer winId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getWinId() {
        return winId;
    }

    public void setWinId(Integer winId) {
        this.winId = winId;
    }
}
