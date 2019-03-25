package xyz.rk.bookshare.service.impl;

import org.springframework.stereotype.Service;
import xyz.rk.bookshare.model.Comment;
import xyz.rk.bookshare.model.Reply;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements xyz.rk.bookshare.service.CommentService {
    @Override
    public List<Comment> getByBookId(int bookId) {
        return null;
    }

    @Override
    public Comment addOneComment(Comment comment) {
        return null;
    }

    @Override
    public Reply addOneReply(Reply reply) {
        return null;
    }

    @Override
    public List<Reply> getByCommentId(int commentId) {
        return null;
    }
}
