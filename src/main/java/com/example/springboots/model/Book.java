package com.example.springboots.model;

public class Book {
    private Integer book_id;

    private String book_name;

    private String writer;

    private String publish;

    private Integer category;

    private String price;

    private String num;

    private Integer admin_book;

    private Bookmark bookmark;

    private Category cate;

    public Book() {
        super();
    }

    public Book(Integer book_id, String book_name, String writer, String publish, Integer category, String price, String num, Integer admin_book, Bookmark bookmark, Category cate) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.writer = writer;
        this.publish = publish;
        this.category = category;
        this.price = price;
        this.num = num;
        this.admin_book = admin_book;
        this.bookmark = bookmark;
        this.cate = cate;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getAdmin_book() {
        return admin_book;
    }

    public void setAdmin_book(Integer admin_book) {
        this.admin_book = admin_book;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", writer='" + writer + '\'' +
                ", publish='" + publish + '\'' +
                ", category=" + category +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", admin_book=" + admin_book +
                ", bookmark=" + bookmark +
                ", cate=" + cate +
                '}';
    }
}