package com.nfl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nfl.pojo.NflUsers;

@Controller

public class HomePageController {
	
	@RequestMapping("/welcome")
	public ModelAndView showHomePage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println(session.getAttribute("user"));
		if(session.getAttribute("user") != null){
			mav.setViewName("redirect:/flow");
			return mav;
		}
		mav.setViewName("welcome");
		return mav;
	}
	
	@RequestMapping("/flow")
	public ModelAndView flow(HttpSession sesßsion){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("flow");
		return mav;
	}
}
