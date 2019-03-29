package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Notice;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.service.NoticeService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public RestBean getAll(){
        List<Notice> notices = noticeService.getAll();
        if (null != notices)
            return RestBean.success(notices, "success");
        return RestBean.commonError("get all notice failed");
    }

    @PutMapping("")
    public RestBean addOne(Notice notice, HttpServletRequest request){
        String tokenStr = request.getHeader("token");

        //第一步，拿到userid
        Token token = userService.getByToken(tokenStr);
        if (null  == token)
            return RestBean.serverError(null, "failed to find user's token info");

        //第二步，存放
        Integer userId = token.getUserid();
        notice.setUserid(userId);
        boolean rs = noticeService.addOne(notice);
        if (rs)
            return RestBean.success(null, "successfully inserted the notice info");
        return RestBean.commonError("insert a notice failed");
    }
}
