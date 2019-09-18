package com.example.springboots.utils;

import com.example.springboots.filter.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截哪些地址
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/selectuser")
                .excludePathPatterns("/user/regist")
                .excludePathPatterns("/user/ActiveMail")
                .excludePathPatterns("/admin/**")
                .excludePathPatterns("/static/jquery-1.11.3.min.js")
                .excludePathPatterns("/BootStrap/js/bootstrap.js")
                .excludePathPatterns("/BootStrap/css/bootstrap.css");
    }
}
