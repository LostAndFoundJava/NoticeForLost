package com.nfl.pojo;

import java.util.Date;

public class NflPosts {
    private Integer id;//Msg_id

    private Integer userId;////User_id

    private Date postTs;//Time

    private Integer postStatus;//原创，评论，转发

    private Integer commentCount;

    private Integer likeCount;

    private Integer shareCount;
    
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostTs() {
        return postTs;
    }

    public void setPostTs(Date postTs) {
        this.postTs = postTs;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }
}