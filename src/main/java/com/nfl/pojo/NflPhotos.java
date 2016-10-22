package com.nfl.pojo;

import java.util.Date;

public class NflPhotos {
    private Integer id;

    private String photokey;

    private Date ts;

    private Integer postId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return photokey;
    }

    public void setKey(String key) {
        this.photokey = key == null ? null : key.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}