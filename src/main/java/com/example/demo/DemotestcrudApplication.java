package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.Mapper")
@SpringBootApplication
public class DemotestcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestcrudApplication.class, args);
    }

}
