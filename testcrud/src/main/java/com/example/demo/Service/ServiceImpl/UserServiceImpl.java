package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public UserServiceImpl() {
        super();
    }

    @Override
    public List<User> findAll()  {
        return userMapper.findAll();
    }

    @Override
    public void updateUser(User user) {
         userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
          userMapper.deleteUser(username);
    }

    @Override
    public void insertIntoUser(User user) {
         userMapper.insertIntoUser(user);
    }
}
