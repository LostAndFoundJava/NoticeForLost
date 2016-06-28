package com.nfl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nfl.pojo.NflUsers;

@Controller
public class HomePageController {
	
	
	@RequestMapping("/guide")
	public ModelAndView guide(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide");
		
		NflUsers user = (NflUsers) session.getAttribute("user");
		
		
		return mav;
	}
}
