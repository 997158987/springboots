package com.example.springboots.model;

public class Bookmark {
    private Integer bookmark_id;

    private Integer bookInfoId;

    private Integer bookmark_user;

    private Book book;

    public Bookmark() {
        super();
    }

    public Bookmark(Integer bookmark_id, Integer bookInfoId, Integer bookmark_user, Book book) {
        this.bookmark_id = bookmark_id;
        this.bookInfoId = bookInfoId;
        this.bookmark_user = bookmark_user;
        this.book = book;
    }

    public Integer getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(Integer bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Integer getBookmark_user() {
        return bookmark_user;
    }

    public void setBookmark_user(Integer bookmark_user) {
        this.bookmark_user = bookmark_user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "bookmark_id=" + bookmark_id +
                ", bookInfoId=" + bookInfoId +
                ", bookmark_user=" + bookmark_user +
                ", book=" + book +
                '}';
    }
}