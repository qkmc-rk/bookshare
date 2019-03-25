package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.rk.bookshare.dao.UserMapper;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.util.AppMD5Util;
import xyz.rk.bookshare.util.RestBean;

import javax.annotation.Resource;
import java.util.Date;

import static xyz.rk.bookshare.util.RestBean.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @Resource
    UserMapper userMapper;

    @GetMapping("/hello")
    public RestBean test(String name){
        User user = new User();
        user.setAccount("xx");
        user.setCreatetime(new Date());
        user.setPassword("xxxx");
        user.setUgrant(new Byte("1"));
        user.setUlock(0);
        userMapper.insert(user);
        if(name != null && name != "")
            return RestBean.success(AppMD5Util.md5Password("ss"),"xx");
        else
            return RestBean.success(AppMD5Util.md5Password("ss"),name);
    }
}
