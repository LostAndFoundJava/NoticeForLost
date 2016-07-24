package com.nfl.pojo;

public class NflPostsPanel extends NflPosts{
	private NflUsers user;
	private NflUsers lastCommentUser;
	public NflUsers getLastCommentUser() {
		return lastCommentUser;
	}
	public void setLastCommentUser(NflUsers lastCommentUser) {
		this.lastCommentUser = lastCommentUser;
	}
	private String postUserName;
	private String postTopic;
	private NflTopics topic;
	public NflTopics getTopic() {
		return topic;
	}
	public void setTopic(NflTopics topic) {
		this.topic = topic;
	}
	public NflUsers getUser() {
		return user;
	}
	public void setUser(NflUsers user) {
		this.user = user;
	}

	
	public String getPostUserName() {
		return postUserName;
	}
	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}
	public String getPostTopic() {
		return postTopic;
	}
	public void setPostTopic(String postTopic) {
		this.postTopic = postTopic;
	}
}

	

