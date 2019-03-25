package xyz.rk.bookshare.service;

import sun.tools.jstat.Token;
import xyz.rk.bookshare.model.User;

import java.util.List;

/**
 * 看不懂那别学java了
 */
public interface UserService {


    List<User> getAll();

    boolean lockUser(int userId);

    boolean unlockUser(int userId);

    boolean updateUser(User user);

    User getById(int userId);

    User login(String account, String password);

    Token getByUserId(int userid);

    boolean regist(User user);

}
