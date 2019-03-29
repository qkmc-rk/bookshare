package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public RestBean getAllUsers(){
        List<User> users = userService.getAll();
        return RestBean.success(users,null);
    }

    @GetMapping("/{userId}")
    public RestBean getUser(@PathVariable int userId){
        User user = userService.getById(userId);
        if(null == user){
            return RestBean.clientError(null,"wrong id");
        }
        return RestBean.success(user,"null");
    }

    @PostMapping("/{userId}")
    public RestBean alterUser(@PathVariable int userId, User user){
        user.setId(userId);
        if (userService.updateUser(user))
            return RestBean.success(null,"update success!");
        return RestBean.commonError("update user failed");
    }

    @PostMapping("/{userId}/lock")
    public RestBean lockUser(@PathVariable int userId){
        if (userService.lockUser(userId))
            return RestBean.success(null, "lock user success");
        return RestBean.serverError(null, "lock user failed");
    }
    @PostMapping("/{userId}/unlock")
    public RestBean unlockUser(@PathVariable int userId){
        if (userService.unlockUser(userId))
            return RestBean.success(null, "ulock user success");
        return RestBean.serverError(null, "ulock user failed");
    }


}
