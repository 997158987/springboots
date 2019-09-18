package com.example.springboots.model;

import java.util.Date;

public class Remark {
    private Integer remark_id;

    private Integer remark_user;

    private String remarkInfo;

    private String remarktime;

    private Integer remark_bookId;

    private User user;

    private Book book;

    public Remark() {
        super();
    }

    public Remark(Integer remark_id, Integer remark_user, String remarkinfo, String remarktime, Integer remark_bookId, User user, Book book) {
        this.remark_id = remark_id;
        this.remark_user = remark_user;
        this.remarkInfo = remarkinfo;
        this.remarktime = remarktime;
        this.remark_bookId = remark_bookId;
        this.user = user;
        this.book = book;
    }

    public Integer getRemark_id() {
        return remark_id;
    }

    public void setRemark_id(Integer remark_id) {
        this.remark_id = remark_id;
    }

    public Integer getRemark_user() {
        return remark_user;
    }

    public void setRemark_user(Integer remark_user) {
        this.remark_user = remark_user;
    }

    public String getRemarkinfo() {
        return remarkInfo;
    }

    public void setRemarkinfo(String remarkinfo) {
        this.remarkInfo = remarkinfo;
    }

    public String getRemarktime() {
        return remarktime;
    }

    public void setRemarktime(String remarktime) {
        this.remarktime = remarktime;
    }

    public Integer getRemark_bookId() {
        return remark_bookId;
    }

    public void setRemark_bookId(Integer remark_bookId) {
        this.remark_bookId = remark_bookId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "remark_id=" + remark_id +
                ", remark_user=" + remark_user +
                ", remarkinfo='" + remarkInfo + '\'' +
                ", remarktime='" + remarktime + '\'' +
                ", remark_bookId=" + remark_bookId +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}