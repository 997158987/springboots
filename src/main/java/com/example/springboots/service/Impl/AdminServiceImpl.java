package com.example.springboots.service.Impl;

import com.example.springboots.mapper.AdminMapper;
import com.example.springboots.mapper.UserMapper;
import com.example.springboots.model.Admin;
import com.example.springboots.model.Book;
import com.example.springboots.model.Category;
import com.example.springboots.model.Orderinfo;
import com.example.springboots.service.AdminService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin select(String admin_name, String admin_pwd) {
        Admin select = adminMapper.select(admin_name, admin_pwd);
        return select;
    }

    @Override
    public Page<Book> selectAdminBook(int admin_book) {
        Page<Book> books = adminMapper.selectAdminBook(admin_book);
        return books;
    }

    @Override
    public Book selectBookById(int book_id) {
        Book book = adminMapper.selectBookById(book_id);
        return book;
    }

    @Override
    public List<Category> selectallCategory() {
        List<Category> category = adminMapper.selectallCategory();
        return category;
    }

    @Override
    public int changeBook(Book book) {
        int i = adminMapper.changeBook(book);
        return i;
    }

    @Override
    public int addBook(Book book) {
        int i = adminMapper.addBook(book);
        return i;
    }

    @Override
    public List<Orderinfo> selectAllOrder(int admin_id) {
        List<Orderinfo> orderinfos = adminMapper.selectAllOrder(admin_id);
        return orderinfos;
    }

    @Override
    public int AdminchangeState(int order_id) {
        return adminMapper.AdminchangeState(order_id);
    }
}
