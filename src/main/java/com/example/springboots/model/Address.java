package com.example.springboots.model;

public class Address {
    private Integer address_id;

    private String reciver;

    private String reciver_phone;

    private String address;

    private String reciver_name;


    private Integer address_user;


    private Integer address_order;


    public Address() {
        super();
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getReciver_phone() {
        return reciver_phone;
    }

    public void setReciver_phone(String reciver_phone) {
        this.reciver_phone = reciver_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReciver_name() {
        return reciver_name;
    }

    public void setReciver_name(String reciver_name) {
        this.reciver_name = reciver_name;
    }

    public Integer getAddress_user() {
        return address_user;
    }

    public void setAddress_user(Integer address_user) {
        this.address_user = address_user;
    }

    public Integer getAddress_order() {
        return address_order;
    }

    public void setAddress_order(Integer address_order) {
        this.address_order = address_order;
    }

    public Address(Integer address_id, String reciver, String reciver_phone, String address, String reciver_name, Integer address_user, Integer address_order) {
        this.address_id = address_id;
        this.reciver = reciver;
        this.reciver_phone = reciver_phone;
        this.address = address;
        this.reciver_name = reciver_name;
        this.address_user = address_user;
        this.address_order = address_order;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", reciver='" + reciver + '\'' +
                ", reciver_phone='" + reciver_phone + '\'' +
                ", address='" + address + '\'' +
                ", reciver_name='" + reciver_name + '\'' +
                ", address_user=" + address_user +
                ", address_order=" + address_order +
                '}';
    }
}