package com.nfl.mapper;

import com.nfl.pojo.NflPhotos;
import com.nfl.pojo.NflPhotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NflPhotosMapper {
    int countByExample(NflPhotosExample example);

    int deleteByExample(NflPhotosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NflPhotos record);

    int insertSelective(NflPhotos record);

    List<NflPhotos> selectByExample(NflPhotosExample example);

    NflPhotos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NflPhotos record, @Param("example") NflPhotosExample example);

    int updateByExample(@Param("record") NflPhotos record, @Param("example") NflPhotosExample example);

    int updateByPrimaryKeySelective(NflPhotos record);

    int updateByPrimaryKey(NflPhotos record);
}