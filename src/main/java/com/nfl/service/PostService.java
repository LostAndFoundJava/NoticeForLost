package com.nfl.service;

import java.util.Map;

public interface PostService {
	public Map<String, Object> newPost(Integer author, String content,Integer post_status,Integer postType);
}
