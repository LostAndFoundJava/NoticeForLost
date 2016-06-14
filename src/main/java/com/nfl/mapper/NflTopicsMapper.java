package com.nfl.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nfl.pojo.NflTopics;
import com.nfl.pojo.NflTopicsExample;

public interface NflTopicsMapper {
    int countByExample(NflTopicsExample example);

    int deleteByExample(NflTopicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflTopics record);

    int insertSelective(NflTopics record);

    List<NflTopics> selectByExample(NflTopicsExample example);

    NflTopics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflTopics record, @Param("example") NflTopicsExample example);

    int updateByExample(@Param("record") NflTopics record, @Param("example") NflTopicsExample example);

    int updateByPrimaryKeySelective(NflTopics record);

    int updateByPrimaryKey(NflTopics record);
}