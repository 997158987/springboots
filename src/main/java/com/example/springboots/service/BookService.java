package com.example.springboots.service;

import com.example.springboots.model.Book;
import com.github.pagehelper.Page;

import java.util.List;

public interface BookService {
    Page<Book> selectAll(int bookmark_user);
}
