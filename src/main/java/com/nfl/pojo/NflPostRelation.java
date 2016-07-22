package com.nfl.pojo;

import java.util.Date;

public class NflPostRelation {
    private Integer id;

    private Integer commentedMsgId;

    private Integer commentedUserId;

    private Integer commentMsgId;

    private Integer commentUserId;

    private Integer commentType;

    private Date commentTime;

    private Integer pageIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentedMsgId() {
        return commentedMsgId;
    }

    public void setCommentedMsgId(Integer commentedMsgId) {
        this.commentedMsgId = commentedMsgId;
    }

    public Integer getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(Integer commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public Integer getCommentMsgId() {
        return commentMsgId;
    }

    public void setCommentMsgId(Integer commentMsgId) {
        this.commentMsgId = commentMsgId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}