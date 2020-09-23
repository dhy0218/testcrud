package com.example.demo.Controller;

import com.example.demo.Dao.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String testIt()
    {
        return "success";
    }

    @RequestMapping(value = "/testFindAll" )
    @ResponseBody
    public List<User> findAlltest() throws SQLException {
        return userService.findAll();
    }

    @RequestMapping(value = "/testUpdate")
    @ResponseBody
    public String updateTest()
    {
        User user = new User();
        user.setPassword(123456);
        user.setUsername("admin");
        userService.updateUser(user);
        return "success";
    }

    @RequestMapping(value = "/testInsert")
    @ResponseBody
    public String insertTest()
    {
        User user = new User();
        user.setPassword(123456);
        user.setUsername("insertadmin");
        userService.insertIntoUser(user);
        return "success";
    }


    @RequestMapping(value = "/testDelete")
    @ResponseBody
    public String deleteTest()
    {
        String username = "admin";
        userService.deleteUser(username);
        return "success";
    }
}
