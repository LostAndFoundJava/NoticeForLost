package com.nfl.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nfl.pojo.NflPhotos;
import com.nfl.pojo.NflPosts;

@Controller
@RequestMapping("/post")
public class PostController {
	private final Logger logger = LogManager.getLogger(PostController.class);
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createPost(HttpSession session) {
		//1. 要做判断，是否登入，如果为登入跳转到
		logger.info("go to the post page");
		return "post/create";
	}
	
	@RequestMapping(value="/uploadpost",method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody NflPosts uploadPost(
										@RequestParam(value="post") String text,
										@RequestParam (value="pic")MultipartFile[]  pics,
										HttpSession session){
		//1.将post存入post对象
		//2.对应图片的存储photos对象
		return null;
	}
}
