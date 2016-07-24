package com.nfl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nfl.mapper.NflTopicsMapper;
import com.nfl.pojo.NflTopics;
import com.nfl.pojo.NflTopicsExample;

@Repository
public class TopicDao {
	
	@Autowired
	private NflTopicsMapper nflTopicMapper;
	
	public NflTopics getTopicByTopicId(Integer topicId){
//		NflTopicsExample topicEx=new NflTopicsExample();
//		NflTopicsExample.Criteria topicExCri=topicEx.createCriteria();
//		NflPostTagExample.Criteria nuec=tagExample.createCriteria();
		NflTopics topic=nflTopicMapper.selectByPrimaryKey(topicId);
		return topic;
	}
}
