package xyz.rk.bookshare.controller;

import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping(value = "/")
public class TestController {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
