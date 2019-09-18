package com.example.springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ces/ces1")
public class testController {

    @RequestMapping("test")
    public String test(){
        return "1";
    }
}
