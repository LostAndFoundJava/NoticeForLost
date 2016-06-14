package com.nfl.mapper;

import com.nfl.pojo.NflPosts;
import com.nfl.pojo.NflPostsExample;
import com.nfl.pojo.NflPostsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NflPostsMapper {
    int countByExample(NflPostsExample example);

    int deleteByExample(NflPostsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflPostsWithBLOBs record);

    int insertSelective(NflPostsWithBLOBs record);

    List<NflPostsWithBLOBs> selectByExampleWithBLOBs(NflPostsExample example);

    List<NflPosts> selectByExample(NflPostsExample example);

    NflPostsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflPostsWithBLOBs record, @Param("example") NflPostsExample example);

    int updateByExampleWithBLOBs(@Param("record") NflPostsWithBLOBs record, @Param("example") NflPostsExample example);

    int updateByExample(@Param("record") NflPosts record, @Param("example") NflPostsExample example);

    int updateByPrimaryKeySelective(NflPostsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NflPostsWithBLOBs record);

    int updateByPrimaryKey(NflPosts record);
}