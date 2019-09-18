package com.example.springboots.controller;

import com.example.springboots.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;


}
