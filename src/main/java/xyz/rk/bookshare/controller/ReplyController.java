package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Reply;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    //获取某个评论的全部回复信息
    @GetMapping("/{commentId}")
    public RestBean getReply(@PathVariable int commentId){
        return null;
    }

    //对某个评论进行回复
    @PutMapping("/{commentId}")
    public RestBean reply(@PathVariable int commentId, @RequestBody Reply reply){
        return null;
    }

}
