package com.example.demo.Controller;

import com.example.demo.Dao.User;
import com.example.demo.Service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;
@ApiOperation("用户测试接口")
@Controller
public class UserController {

    @Autowired
    UserService userService;



    @ApiOperation("测试不用注解包裹controller能否接收到")
    @RequestMapping(value = "/withoutAnoTest" )
    @ResponseBody
    public User withoutAnoTest(int id) throws SQLException {
        return userService.findById(id);
    }

    @ApiOperation("根据id查询用户测试")
    @RequestMapping(value = "/testFindTestById/{id}" )
    @ResponseBody
    public User findTestById(@PathVariable int id) throws SQLException {
        return userService.findById(id);
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
