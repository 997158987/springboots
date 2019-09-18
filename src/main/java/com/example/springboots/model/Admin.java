package com.example.springboots.model;

public class Admin {
    private Integer admin_id;


    private String admin_name;


    private String admin_pwd;


    private Book book;

    public Admin() {
        super();
    }

    public Admin(Integer admin_id, String admin_name, String admin_pwd, Book book) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_pwd = admin_pwd;
        this.book = book;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                ", book=" + book +
                '}';
    }
}