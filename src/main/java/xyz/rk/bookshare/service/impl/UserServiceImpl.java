package xyz.rk.bookshare.service.impl;

import org.springframework.stereotype.Service;
import sun.tools.jstat.Token;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
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
        return null;
    }

    @Override
    public Token getByUserId(int userid) {
        return null;
    }

    @Override
    public boolean regist(User user) {
        return false;
    }
}
