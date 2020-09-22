package com.example.demo;

import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class DemotestcrudApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserService userService;

    @Test
    public void test() throws SQLException {

        System.out.println(userService.findAll());
    }
}
