package com.nfl.pojo;

import java.util.Date;

public class NflTopics {
    private Integer id;

    private String topicName;

    private Date addTs;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    public Date getAddTs() {
        return addTs;
    }

    public void setAddTs(Date addTs) {
        this.addTs = addTs;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}