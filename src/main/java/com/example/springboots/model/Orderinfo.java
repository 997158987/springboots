package com.example.springboots.model;

import org.apache.ibatis.annotations.Insert;

import java.util.Date;

public class Orderinfo {
    private Integer orderaddress;

    private Integer orderId;

    private Integer orderbookId;

    private Integer admin_id;

    private Book book;

    private Address address;

    private Order order;

    private Admin admin;

    public Orderinfo() {
        super();
    }

    public Orderinfo(Integer orderaddress, Integer orderId, Integer orderbookId, Integer admin_id, Book book, Address address, Order order, Admin admin) {
        this.orderaddress = orderaddress;
        this.orderId = orderId;
        this.orderbookId = orderbookId;
        this.admin_id = admin_id;
        this.book = book;
        this.address = address;
        this.order = order;
        this.admin = admin;
    }

    public Integer getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(Integer orderaddress) {
        this.orderaddress = orderaddress;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderbookId() {
        return orderbookId;
    }

    public void setOrderbookId(Integer orderbookId) {
        this.orderbookId = orderbookId;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Orderinfo{" +
                "orderaddress=" + orderaddress +
                ", orderId=" + orderId +
                ", orderbookId=" + orderbookId +
                ", admin_id=" + admin_id +
                ", book=" + book +
                ", address=" + address +
                ", order=" + order +
                ", admin=" + admin +
                '}';
    }
}