package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Reply;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.service.CommentService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    //获取某个评论的全部回复信息
    @GetMapping("/{commentId}")
    public RestBean getReply(@PathVariable int commentId){
        List<Reply> replies = commentService.getReplyByCommentId(commentId);
        if (null != replies)
            return RestBean.success(replies, "succefully get replies");
        return RestBean.commonError("no replies find");
    }

    //对某个评论进行回复
    @PutMapping("/{commentId}")
    public RestBean reply(@PathVariable int commentId, Reply reply, HttpServletRequest request){
        //第一步，获取
        String tokenStr = request.getHeader("token");

        Token token = userService.getByToken(tokenStr);
        Integer userid = token.getUserid();

        reply.setCommentid(commentId);
        reply.setCreatetime(new Date());
        reply.setUserid(userid);

        Reply reply1 = commentService.addOneReply(reply);
        if (null != reply1)
            return  RestBean.success(reply1, "success");
        return RestBean.commonError("failed to add reply");
    }

}
