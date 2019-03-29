package xyz.rk.bookshare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.rk.bookshare.dao.CommentMapper;
import xyz.rk.bookshare.dao.ReplyMapper;
import xyz.rk.bookshare.model.Comment;
import xyz.rk.bookshare.model.Reply;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements xyz.rk.bookshare.service.CommentService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    CommentMapper commentMapper;

    @Resource
    ReplyMapper replyMapper;

    @Override
    public List<Comment> getByBookId(int bookId) {
        List<Comment> comments = null;
        try {
            comments = commentMapper.selectByBookId(bookId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("find some comments by book id failed book id is :" + bookId );
        }
        return comments;
    }

    @Override
    public Comment addOneComment(Comment comment) {
        int rs = 0;
        try {
            rs = commentMapper.insert(comment);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but insert comment failed");
            return null;
        }
        if (rs > 0)
            return comment;//no comment id
        return null;
    }

    @Override
    public Reply addOneReply(Reply reply) {
        int rs = 0;
        try {
            rs = replyMapper.insert(reply);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("failed to add one reply");
        }
        if (rs > 0)
            return reply;
        return null;
    }

    @Override
    public List<Reply> getByCommentId(int commentId) {
        return null;
    }

    @Override
    public List<Reply> getReplyByCommentId(int commentId) {
        List<Reply> replies = null;
        try {
            replies = replyMapper.selectByCommentId(commentId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("failed to find some reply for the comment,id:" + commentId);
        }
        return replies;
    }
}
