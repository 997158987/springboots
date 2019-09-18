package com.example.springboots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootsApplication.class, args);
    }

}
