package com.example.springboots.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer order_id;

    private String order_time;

    private Integer total;

    private Integer order_state;

    private Integer order_user;

    private List<Orderinfo> orderinfo;

    private OrderState orderState1;

    public Order() {
        super();
    }

    public Order(Integer order_id, String order_time, Integer total, Integer order_state, Integer order_user, List<Orderinfo> orderinfo, OrderState orderState1) {
        this.order_id = order_id;
        this.order_time = order_time;
        this.total = total;
        this.order_state = order_state;
        this.order_user = order_user;
        this.orderinfo = orderinfo;
        this.orderState1 = orderState1;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOrder_state() {
        return order_state;
    }

    public void setOrder_state(Integer order_state) {
        this.order_state = order_state;
    }

    public Integer getOrder_user() {
        return order_user;
    }

    public void setOrder_user(Integer order_user) {
        this.order_user = order_user;
    }

    public List<Orderinfo> getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(List<Orderinfo> orderinfo) {
        this.orderinfo = orderinfo;
    }

    public OrderState getOrderState1() {
        return orderState1;
    }

    public void setOrderState1(OrderState orderState1) {
        this.orderState1 = orderState1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_time='" + order_time + '\'' +
                ", total='" + total + '\'' +
                ", order_state=" + order_state +
                ", order_user=" + order_user +
                ", orderinfo=" + orderinfo +
                ", orderState1=" + orderState1 +
                '}';
    }
}