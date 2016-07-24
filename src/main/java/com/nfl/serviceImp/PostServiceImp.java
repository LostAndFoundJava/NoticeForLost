package com.nfl.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfl.dao.CommentDao;
import com.nfl.dao.PostDao;
import com.nfl.dao.TopicDao;
import com.nfl.pojo.NflCommentsUsers;
import com.nfl.pojo.NflPostRelation;
import com.nfl.pojo.NflPosts;
import com.nfl.pojo.NflPostsPanel;
import com.nfl.pojo.NflTopics;
import com.nfl.service.PostService;
import com.nfl.util.PostDic;
import com.nfl.util.Property;

@Service("postService")
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private CommentDao commentDao;

	private List<NflPostRelation> nflRe;
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

	public NflPostsPanel getPost(String postId) throws Exception{
		// TODO 显示具体的帖子的内容
		List<NflPostsPanel> posts=null;
		List<NflCommentsUsers> nflRe = null;
		NflCommentsUsers lastComment=null;
		NflPostsPanel post=null;
		if(!isNumeric(postId)){
			return post;
		}
		int intPostId = Integer.valueOf(postId);
		posts=postDao.queryById(intPostId);
		if(posts.size()>1){
			throw new Exception("wrong query reslut!");
		}
		nflRe=commentDao.queryCommentsRetionWithUsersByPostId(intPostId);
		if(nflRe!=null || nflRe.size()!=0){
			lastComment=nflRe.get(0);
		}
		post=posts.get(0);
		post.setLastCommentUser(lastComment.getUser());
		return post;
	}
	
	private boolean isNumeric(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){  
		    return false;  
		   }  
		  }  
		  return true;  
		} 

}
