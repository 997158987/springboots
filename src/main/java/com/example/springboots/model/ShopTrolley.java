package com.example.springboots.model;

public class ShopTrolley {
    private Integer shop_trolleyId;

    private Integer trolley_user;

    private Integer trolley_book;

    private Book book;

    public ShopTrolley() {
        super();
    }

    public ShopTrolley(Integer shop_trolleyId, Integer trolley_user, Integer trolley_book, Book book) {
        this.shop_trolleyId = shop_trolleyId;
        this.trolley_user = trolley_user;
        this.trolley_book = trolley_book;
        this.book = book;
    }

    public Integer getShop_trolleyId() {
        return shop_trolleyId;
    }

    public void setShop_trolleyId(Integer shop_trolleyId) {
        this.shop_trolleyId = shop_trolleyId;
    }

    public Integer getTrolley_user() {
        return trolley_user;
    }

    public void setTrolley_user(Integer trolley_user) {
        this.trolley_user = trolley_user;
    }

    public Integer getTrolley_book() {
        return trolley_book;
    }

    public void setTrolley_book(Integer trolley_book) {
        this.trolley_book = trolley_book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "ShopTrolley{" +
                "shop_trolleyId=" + shop_trolleyId +
                ", trolley_user=" + trolley_user +
                ", trolley_book=" + trolley_book +
                ", book=" + book +
                '}';
    }
}