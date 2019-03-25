package xyz.rk.bookshare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

/**
 * 该controll用于注册与登录
 */
@RestController
public class LoginRegistController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public RestBean login(@RequestParam(required = true) String account
            , @RequestParam(required = true) String password){
        return null;
    }

    @RequestMapping("/regist")
    public RestBean regitst(@RequestBody User user){
        return null;
    }
}
