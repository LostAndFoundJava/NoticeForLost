package com.nfl.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.JsonObject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.nfl.pojo.NflPhotos;
import com.nfl.pojo.NflPosts;

import com.nfl.pojo.NflUsers;
import com.nfl.serviceImp.PostServiceImp;
import com.nfl.util.PostDic;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	public PostServiceImp postService;
	
	
	private final Logger logger = LogManager.getLogger(PostController.class);
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createPost(HttpSession session) {
		//1. 要做判断，是否登入，如果为登入跳转到
		logger.info("go to the post page");
		return "post/create";
	}
	
	@RequestMapping(value="/uploadpost",method=RequestMethod.POST ,produces = "application/json;charset=UTF-8" ) 
	public @ResponseBody Object uploadPost(
										@RequestParam("content") String content,
										@RequestParam("post_status") Integer post_status,
										//@RequestParam("post_type") String postType,
										//*@RequestParam (value="pic")MultipartFile[]  pics,*/
										HttpSession session){
		
		//1.将post存入post对象
		//2.对应图片的存储photos对象
		Map<String, Object> map = new HashMap<String, Object>();
		NflUsers user = (NflUsers) session.getAttribute("user");
		//判断是session 是否过期
		if(user==null)
			return map;
		//-------
		//要不要传时间？
		System.out.println(content);
		logger.info("start upload");
		map=postService.newPost(user.getId(),content,post_status,PostDic.NEWPOST);
		logger.info("uploaded");
		System.out.println(content);
		return map;
	}
}
