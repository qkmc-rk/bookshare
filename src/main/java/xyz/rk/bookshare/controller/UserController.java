package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("")
    public RestBean getAllUsers(){
        return null;
    }

    @GetMapping("/{userId}")
    public RestBean getUser(@PathVariable int userId){
        return null;
    }

    @PostMapping("/{userId}")
    public RestBean alterUser(@PathVariable int userId, @RequestBody User user){
        return null;
    }

    @PostMapping("/{userId}/lock")
    public RestBean lockUser(@PathVariable int userIs){
        return null;
    }
    @PostMapping("/{userId}/unlock")
    public RestBean unlockUser(@PathVariable int userId){
        return null;
    }


}
