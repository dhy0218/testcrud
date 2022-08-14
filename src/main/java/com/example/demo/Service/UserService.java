package com.example.demo.Service;

import com.example.demo.Dao.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    public List<User> findAll() throws SQLException;
    public User findById(int id) throws SQLException;
    public  void updateUser(User user);
    public  void deleteUser(String username);
    public  void insertIntoUser(User user);
}
