package com.naruto.mengzhiayuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/27 11:33
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;

    //头像
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;

    private DetailedBlog blog;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public void setBlog(DetailedBlog blog) {
        this.blog = blog;
    }
}
