package com.nfl.serviceImp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfl.dao.PostDao;
import com.nfl.pojo.NflPosts;
import com.nfl.service.PostService;
import com.nfl.util.Property;

@Service("postService")
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Override
	public Map<String, Object> newPost(Integer author, String content, Integer post_status,Integer postType) {
		Map<String, Object> statusMap = new HashMap<String, Object>();
		
		NflPosts post=new NflPosts();
		post.setUserId(author);
		post.setPostContent(content);
		post.setPostStatus(post_status);
		post.setPostType(postType);
		int postId=postDao.savePost(post);
		if(postId!=0)
			statusMap.put("status", Property.SUCCESS_POST_CREATE);
		else
			statusMap.put("status", Property.ERROR_POST_STATUS);
		return statusMap;
	
	}
	

}
