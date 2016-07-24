package com.nfl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nfl.mapper.NflPostPanelMapper;
import com.nfl.mapper.NflPostsMapper;
import com.nfl.pojo.NflPosts;
import com.nfl.pojo.NflPostsExample;
import com.nfl.pojo.NflPostsPanel;
import com.nfl.pojo.NflUsers;
import com.nfl.pojo.NflUsersExample;

@Repository("postDao")
public class PostDao {
	
	@Autowired
	private NflPostPanelMapper postPanelMapper;
	
	@Autowired
	private NflPostsMapper postMapper;
	
	public int savePost(NflPosts post){
		int postId=postMapper.insertSelective(post);
		return postId;
	}

	public List<NflPostsPanel> queryById(Integer postId) {
		// TODO Auto-generated method stub
		List<NflPostsPanel> panel=postPanelMapper.findPostUserAndTopic(postId);
		System.out.println(panel.size());
		return panel;
	}
}
