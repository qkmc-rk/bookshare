package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Comment;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.service.CommentService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    //获取某本书的全部评论
    @GetMapping("/{bookId}")
    public RestBean getComments(@PathVariable int bookId){
        List<Comment> comments = commentService.getByBookId(bookId);

        if (null != comments)
            return RestBean.success(comments, "find comments");
        return RestBean.commonError("no comments");
    }


    //对某本书进行评论
    @PutMapping("/{bookId}")
    public RestBean comment(@PathVariable int bookId, Comment comment, HttpServletRequest request){
//第一步，获取
        String tokenStr = request.getHeader("token");

        Token token = userService.getByToken(tokenStr);
        System.out.println(token);
        System.out.println(userService);
        Integer userid = token.getUserid();

        comment.setUserid(userid);
        comment.setBookid(bookId);
        comment.setCreatetime(new Date());

        comment = commentService.addOneComment(comment);
        if (null != comment)
            return RestBean.success(comment, "successfully add comment");
        return RestBean.serverError(null, "sorry but failed to add one comment");
    }

}
