package com.nfl.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.nfl.pojo.NflPostsPanel;

public class NflPostPanelMapperTest {
	

 
    @Test  
    public void testInsert() {  
    	String resource = "spring/applicationContext.xml";
    	InputStream inputStream;
    	SqlSessionFactory	sqlSessionFactory=null ;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       SqlSession sqlSession = sqlSessionFactory.openSession();  
       try {  
           NflPostPanelMapper post=sqlSession.getMapper(NflPostPanelMapper.class);
          NflPostsPanel pan= post.findPostUserAndTopic(Integer.valueOf(1));
          System.out.println(pan.getPost_userName());
       } finally {  
           sqlSession.close();  
       }  
    }  


}
