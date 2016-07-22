package com.nfl.mapper;

import com.nfl.pojo.NflPosts;
import com.nfl.pojo.NflPostsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NflPostsMapper {
    int countByExample(NflPostsExample example);

    int deleteByExample(NflPostsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflPosts record);

    int insertSelective(NflPosts record);

    List<NflPosts> selectByExampleWithBLOBs(NflPostsExample example);

    List<NflPosts> selectByExample(NflPostsExample example);

    NflPosts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflPosts record, @Param("example") NflPostsExample example);

    int updateByExampleWithBLOBs(@Param("record") NflPosts record, @Param("example") NflPostsExample example);

    int updateByExample(@Param("record") NflPosts record, @Param("example") NflPostsExample example);

    int updateByPrimaryKeySelective(NflPosts record);

    int updateByPrimaryKeyWithBLOBs(NflPosts record);

    int updateByPrimaryKey(NflPosts record);
}