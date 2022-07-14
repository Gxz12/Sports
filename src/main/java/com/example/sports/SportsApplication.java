package com.example.sports;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.sports.DAO")
@ComponentScan("com.example.sports.Service")
@ComponentScan(basePackages = "com.example.sports.Controller")
@ComponentScan(basePackages ="com.example")
public class SportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsApplication.class, args);
    }




}
