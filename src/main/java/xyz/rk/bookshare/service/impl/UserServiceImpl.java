package xyz.rk.bookshare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.rk.bookshare.dao.TokenMapper;
import xyz.rk.bookshare.dao.UserMapper;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.AppMD5Util;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource  //resource与autowired有一些小区别
    private  UserMapper userMapper;

    @Resource
    private TokenMapper tokenMapper;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean lockUser(int userId) {
        return false;
    }

    @Override
    public boolean unlockUser(int userId) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getById(int userId) {
        return null;
    }

    @Override
    public User login(String account, String password) {
        password = AppMD5Util.md5Password(password);
        User user = null;
        try {
            user = userMapper.selectByAccount(account,password);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询用户出错了，抛出了异常，可能是有多个相同用户");
        }
        return user;
    }

    @Override
    public Token getByUserId(int userid) {
        Token token;
        try {
            token = tokenMapper.selectByUserId(userid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("傻逼，查询token出错了！！！");
        }

        return null;
    }

    @Override
    public boolean regist(User user) {
        //生成一个用户，然后，生成一个token
        return false;
    }
}
