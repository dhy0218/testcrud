package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.sql.SQLException;
import java.util.List;
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public UserServiceImpl() {
        super();
    }

    @Override
    public List<User> findAll()  {
        log.info("testTask start");
        StopWatch sw = new StopWatch();
        sw.start("testTask");
        List<User> list = userMapper.findAll();
        sw.stop();
        log.info("testTask finish");
        log.info(sw.prettyPrint());
        log.info(String.valueOf(sw.getLastTaskTimeMillis()));
        return list;
    }

    @Override
    public User findById(int id) throws SQLException {
        return userMapper.findById(id);
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
