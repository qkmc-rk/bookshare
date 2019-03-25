package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Comment;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping("/comment")
public class CommentController {

    //获取某本书的全部评论
    @GetMapping("/{bookId}")
    public RestBean getComments(@RequestParam int bookId){
        return null;
    }


    //对某本书进行评论
    @PutMapping("/{bookId}")
    public RestBean comment(@RequestParam int bookId,@RequestBody Comment comment){
        return null;
    }

}
