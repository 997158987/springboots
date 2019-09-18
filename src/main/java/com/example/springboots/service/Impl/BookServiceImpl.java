package com.example.springboots.service.Impl;

import com.example.springboots.mapper.BookMapper;
import com.example.springboots.model.Book;
import com.example.springboots.service.BookService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public Page<Book> selectAll(int bookmark_user) {
        return bookMapper.selectAll(bookmark_user);
    }
}
