package com.nfl.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nfl.pojo.NflUsers;
import com.nfl.pojo.NflUsersExample;

public interface NflUsersMapper {
    int countByExample(NflUsersExample example);

    int deleteByExample(NflUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflUsers record);

    int insertSelective(NflUsers record);

    List<NflUsers> selectByExample(NflUsersExample example);

    NflUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflUsers record, @Param("example") NflUsersExample example);

    int updateByExample(@Param("record") NflUsers record, @Param("example") NflUsersExample example);

    int updateByPrimaryKeySelective(NflUsers record);

    int updateByPrimaryKey(NflUsers record);
}