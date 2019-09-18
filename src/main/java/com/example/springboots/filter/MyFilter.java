//package com.example.springboots.filter;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter("/*")
//@Component
//public class MyFilter implements Filter {
//
//    public MyFilter() {
//        System.out.println("这是构造方法");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("筛选");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("结束");
//    }
//}
