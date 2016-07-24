package com.nfl.service;

import java.util.List;
import java.util.Map;

import com.nfl.pojo.NflPosts;
import com.nfl.pojo.NflPostsPanel;

public interface PostService {
	public Map<String, Object> newPost(Integer author, String content,Integer post_status,Integer postType);

	NflPostsPanel getPost(String postId) throws Exception;
}
