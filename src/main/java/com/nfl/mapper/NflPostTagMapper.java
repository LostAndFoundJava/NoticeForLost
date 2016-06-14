package com.nfl.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nfl.pojo.NflPostTag;
import com.nfl.pojo.NflPostTagExample;

public interface NflPostTagMapper {
    int countByExample(NflPostTagExample example);

    int deleteByExample(NflPostTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflPostTag record);

    int insertSelective(NflPostTag record);

    List<NflPostTag> selectByExample(NflPostTagExample example);

    NflPostTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflPostTag record, @Param("example") NflPostTagExample example);

    int updateByExample(@Param("record") NflPostTag record, @Param("example") NflPostTagExample example);

    int updateByPrimaryKeySelective(NflPostTag record);

    int updateByPrimaryKey(NflPostTag record);
}