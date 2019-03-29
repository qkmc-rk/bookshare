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
import xyz.rk.bookshare.util.Constant;

import javax.annotation.Resource;
import java.util.Date;
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
        List<User> users = null;

        try {
            users = userMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("cant zhaodao many yonghus.");
        }

        return users

            /*
            宝宝不开心，宝宝心里苦，宝宝要打人！
             */
                ;
    }

    @Override
    public boolean lockUser(int userId) {
        int rs = 0;
        try {
            rs = userMapper.updateUlockById(userId,Constant.LOCKED);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but updateUlockById failed:userId:" + userId + ",lock id :" + Constant.LOCKED);
        }
        if(rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean unlockUser(int userId) {
        int rs = 0;
        try {
            rs = userMapper.updateUlockById(userId,Constant.UNLOCKED);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but updateUlockById failed:userId:" + userId + ",lock id :" + Constant.LOCKED);
        }
        if(rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        int rs;
        //尝试更新user

        try {
            rs = userMapper.updateUserPrimInfoByPrimaryKey(user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry update user failed.");
            return false;
        }

        if(rs != 1)
            return false;
        return true;
    }

    @Override
    public User getById(int userId) {
        User user = null;

        try {
            user = userMapper.selectByPrimaryKey(userId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but I cant find the user where id = " + userId);
        }
        return user;
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
        //如果没找到 返回错误信息
        Token token = null;
        try {
            token = tokenMapper.selectByUserId(userid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("傻逼，查询token出错了！！！");
        }
        return token;
    }

    @Override
    public User regist(User user) {
        //生成一个用户，然后，生成一个token

        //加密用户密码
        String password =user.getPassword();
        password = AppMD5Util.md5Password(password);
        user.setPassword(password);

        //绑定相关系数
        user.setCreatetime(new Date());
        user.setUgrant(Constant.USUAL_CUSTOM);
        user.setUlock(Constant.UNLOCKED);

        int rs = 0;
        //先存用户，然后获得id后，可以增加ID，这里需要回滚，防止用户增加了却没有token
        try {
            rs = userMapper.insert(user);

            //成功
            user = userMapper.selectByAccount(user.getAccount(),user.getPassword());

        }catch (Exception e){
            e.printStackTrace();
            logger.error("不好意思，没注册成功啊！！");
        }
        //integer 强转 int
        if(rs != Constant.SUCCESS){
            //失败
            return null;
        }

        //重置rs,用于token
        rs = 0;
        //new一个token
        Token token = new Token();
        Date date = new Date();
        token.setCreatetime(new Date());
        token.setFrame(Constant.TOKEN_FRAME);
        token.setFreshtime(new Date());
        //注意token的生成方式 密码加当前时间，然后在MD5加密
        token.setToken(AppMD5Util.md5Password(user.getPassword() + String.valueOf(new Date())));
        token.setUserid(user.getId());

        try {
            rs = tokenMapper.insert(token);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("不好意思，token插入失败了，我现在要回滚，删除刚刚插入的user");
            userMapper.deleteByPrimaryKey(user.getId());
            return null;
        }
        //成功了注册
        return user;
    }

    @Override
    public Token getByToken(String tokenStr) {
        Token token = null;
        try {
            token= tokenMapper.selectByToken(tokenStr);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("cant get token");
        }
        return token;
    }
}
