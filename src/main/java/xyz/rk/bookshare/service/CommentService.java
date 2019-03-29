package xyz.rk.bookshare.service;

import xyz.rk.bookshare.model.Comment;
import xyz.rk.bookshare.model.Reply;

import java.util.List;

public interface CommentService {

    List<Comment> getByBookId(int bookId);

    Comment addOneComment(Comment comment);

    Reply addOneReply(Reply reply);

    List<Reply> getByCommentId(int commentId);

    List<Reply> getReplyByCommentId(int commentId);
}
