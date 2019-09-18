package com.example.springboots.model;

public class User {
    private Integer user_id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer gender;

    private Address address;

    private Integer state;

    private ShopTrolley shopTrolley;

    private Order order;

    private Bookmark bookmark;

    private Remark remark;

    public User() {
        super();
    }

    public User(Integer user_id, String username, String password, String phone, String email, Integer gender, Address address, Integer state, ShopTrolley shopTrolley, Order order, Bookmark bookmark, Remark remark) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.shopTrolley = shopTrolley;
        this.order = order;
        this.bookmark = bookmark;
        this.remark = remark;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public ShopTrolley getShopTrolley() {
        return shopTrolley;
    }

    public void setShopTrolley(ShopTrolley shopTrolley) {
        this.shopTrolley = shopTrolley;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    public Remark getRemark() {
        return remark;
    }

    public void setRemark(Remark remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", state=" + state +
                ", shopTrolley=" + shopTrolley +
                ", order=" + order +
                ", bookmark=" + bookmark +
                ", remark=" + remark +
                '}';
    }
}