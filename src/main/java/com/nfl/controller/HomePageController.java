package com.nfl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nfl.pojo.NflUsers;

@Controller
public class HomePageController {
	
	@RequestMapping("/")
	public ModelAndView showHomePage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("user_email") != null){
			mav.setViewName("redirect:/guide");
			return mav;
		}
		mav.setViewName("welcome");
		return mav;
		
	}
	
	@RequestMapping("/guide")
	public ModelAndView guide(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide");
		return mav;
	}
}
