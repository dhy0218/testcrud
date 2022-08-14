package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Dao.User;
import com.example.demo.Mapper.UserXmlTestMapper;
import com.example.demo.util.ThreadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class testXmlCrud {
    @Autowired(required = false)
    UserXmlTestMapper userXmlTestMapper;

    @RequestMapping(value = "/testFindXMLAll" )
    @ResponseBody
    public List<User> findAlltest() throws SQLException {
        return userXmlTestMapper.findAll();
    }

    @RequestMapping(value = "/testpage" )
    @ResponseBody
    public IPage<User> findpage(@ApiIgnore Page page) throws ExecutionException, InterruptedException {
        //test executorservice
        Future<List<User>> future1 = null;
        Future<IPage<User>> future2 = null;
        future1 = ThreadManager.fixedThreadPool.submit(()->userXmlTestMapper.findAll());
        future2 = ThreadManager.fixedThreadPool.submit(()->userXmlTestMapper.pageQury(page));
        System.out.println("this is the future1");
        System.out.println(future1.get());
        System.out.println("this is the future2");
        System.out.println(future2.get().getRecords());
        IPage<User> result = userXmlTestMapper.pageQury(page);
        System.out.println(result);
        return result;
    }

}
