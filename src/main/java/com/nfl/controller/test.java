package com.nfl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.nfl.pojo.NflUsers;
import com.nfl.serviceImp.UserServiceImp;

@Controller
@RequestMapping("/hello")
public class test {
	@Autowired
	private UserServiceImp userService;
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String index(){
		System.out.println("ok,well done!!!");
		return "index";
	}
	/**
	 * 1.
	 * @param user_name
	 * @param user_desc
	 * @return
	 */
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public String adduser(
				@RequestParam("userName") String user_name,
				@RequestParam("userEmail") String user_email) {
		NflUsers user=new NflUsers();
		user.setUserName(user_name);
		user.setUserEmail(user_email);
		userService.addUser(user);
		return "index";
	}
}
