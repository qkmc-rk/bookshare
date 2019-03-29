package xyz.rk.bookshare.util;

import xyz.rk.bookshare.model.User;

public class UserUtil {

     public static synchronized  User wipeSecInfo(User user){
         user.setUlock(null);
         user.setUgrant(null);
         user.setCreatetime(null);
         user.setPassword(null);
         user.setAccount(null);
        return user;
    }
}
