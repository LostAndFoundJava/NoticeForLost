package com.nfl.mapper;

import com.nfl.pojo.NflPostRelation;
import com.nfl.pojo.NflPostRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NflPostRelationMapper {
    int countByExample(NflPostRelationExample example);

    int deleteByExample(NflPostRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflPostRelation record);

    int insertSelective(NflPostRelation record);

    List<NflPostRelation> selectByExample(NflPostRelationExample example);

    NflPostRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflPostRelation record, @Param("example") NflPostRelationExample example);

    int updateByExample(@Param("record") NflPostRelation record, @Param("example") NflPostRelationExample example);

    int updateByPrimaryKeySelective(NflPostRelation record);

    int updateByPrimaryKey(NflPostRelation record);
}