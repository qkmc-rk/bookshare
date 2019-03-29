package xyz.rk.bookshare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Token;
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
        User user = userService.login(account,password);
        if(null != user){
            Token token = userService.getByUserId(user.getId());
            return RestBean.success(token,"login success");
        }
        return RestBean.serverError(null,"service returns null");
    }

    @PostMapping(value = "/regist",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestBean regitst(User user){
        if(null != (user = userService.regist(user))){
            //注册成功
            Token token = userService.getByUserId(user.getId());
            return RestBean.success(token,"regist success");
        }else{
            return RestBean.serverError(null,"service returns null");
        }
    }
}
