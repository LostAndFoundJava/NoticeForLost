package com.nfl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nfl.mapper.NflCommentsUsersMapper;
import com.nfl.mapper.NflPostRelationMapper;
import com.nfl.mapper.NflPostsMapper;
import com.nfl.pojo.NflCommentsUsers;
import com.nfl.pojo.NflPostRelation;
import com.nfl.pojo.NflPostRelationExample;
import com.nfl.pojo.NflPosts;

@Repository("commentDao")
public class CommentDao {
	@Autowired
	public NflPostRelationMapper postRelationMapper;
	
	@Autowired
	public NflCommentsUsersMapper commentsUsersMapper;
	
	public List<NflPostRelation> queryCommentsRetionByPostId(Integer postId,String orderClause){
		List<NflPostRelation> nflPostRelations=new ArrayList<NflPostRelation>();
		NflPostRelationExample reEx=new NflPostRelationExample();
		reEx.setOrderByClause(orderClause);
		reEx.or().andCommentedMsgIdEqualTo(postId);
		nflPostRelations=postRelationMapper.selectByExample(reEx);
		return nflPostRelations;
	}
	
	public List<NflCommentsUsers> queryCommentsRetionWithUsersByPostId(Integer postId){
		List<NflCommentsUsers> commentsRewithUser=null;
		commentsRewithUser=commentsUsersMapper.findNflCommentsUsers(postId);
		return commentsRewithUser;
	}
}
