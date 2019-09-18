package com.example.springboots.service;

import com.example.springboots.mapper.AdminMapper;
import com.example.springboots.mapper.UserMapper;
import com.example.springboots.model.Admin;
import com.example.springboots.model.Book;
import com.example.springboots.model.Category;
import com.example.springboots.model.Orderinfo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    Admin select(String admin_name, String admin_pwd);
    Page<Book> selectAdminBook(int admin_book);
    Book selectBookById(int book_id);
    List<Category> selectallCategory();
    int changeBook(Book book);
    int addBook(Book book);
    List<Orderinfo> selectAllOrder(int admin_id);
    int AdminchangeState(int order_id);
}
