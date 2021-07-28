package com.naruto.mengzhiayuan.service;

import com.naruto.mengzhiayuan.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
