package com.nfl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nfl.mapper.NflPostsMapper;
import com.nfl.pojo.NflPostsWithBLOBs;

@Repository("postDao")
public class PostDao {
	
	@Autowired
	private NflPostsMapper postMapper;
	
	public int savePost(NflPostsWithBLOBs post){
		int postId=postMapper.insert(post);
		return postId;
	}
}
