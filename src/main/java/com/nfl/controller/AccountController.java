package com.nfl.controller;

import com.nfl.pojo.NflUsers;
import com.nfl.pojo.NflUsersCustom;
import com.nfl.service.MailService;
import com.nfl.service.imp.UserServiceImp;
import com.nfl.util.Property;
import com.nfl.util.UserDic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
    private UserServiceImp userService;
	
	@Autowired
	@Qualifier("mailService")
	private MailService mailService;
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpSession session,Model model) {
		if(session.getAttribute("user")!=null)
			return "redirect:/flow";
        return "account/register";
    }

	@ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, String> register(@RequestBody NflUsersCustom user) throws Exception {
        System.out.println("register....");
        //存储id，激活key和注册成功与否status
        Map<String, String> map = new HashMap<String, String>();
        String status = userService.register(user, map);
        if (Property.SUCCESS_ACCOUNT_REG.equals(status)) {
            mailService.sendAccountActivationEmail(user.getUserEmail(), map.get("activationKey"));
        }
        map.put("status", status);
        return map;
    }
	
	@RequestMapping("/activation/{key}")
	public ModelAndView activation(@PathVariable("key") String key,
			@RequestParam("email") String email, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		String status = null;
		try {
			status = userService.activateUser(email, URLDecoder.decode(key, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (Property.SUCCESS_ACCOUNT_ACTIVATION.equals(status)
				|| Property.ERROR_ACCOUNT_EXIST.equals(status)) {
			mav.setViewName("redirect:/flow");
			//这里和搜索有关系
//			NflUsers user = userService.findByEmail(email);
//			session.setAttribute("user", user);
//			userService.indexUser(user);
		} else {
			mav.setViewName("account/activation");
			mav.addObject("status", status);
			mav.addObject("email", email);
			mav.addObject("ERROR_ACCOUNT_ACTIVATION_NOTEXIST",
					Property.ERROR_ACCOUNT_ACTIVATION_NOTEXIST);
			mav.addObject("ERROR_ACCOUNT_ACTIVATION_EXPIRED",
					Property.ERROR_ACCOUNT_ACTIVATION_EXPIRED);
			mav.addObject("ERROR_ACCOUNT_ACTIVATION",
					Property.ERROR_ACCOUNT_ACTIVATION);
		}
		return mav;
	}
	
	
	@RequestMapping("/activation/mail/send")
	public ModelAndView activation(@RequestParam("email") String email, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		NflUsers user=(NflUsers)session.getAttribute("user");
		//如果已登入，跳转到首页
		if(user!=null){
			mav.setViewName("redirect:/flow");
			return mav;			
		}
		if(user.getUserStatus()==UserDic.STATUS_USER_NORMAL){
			mav.setViewName("account/login");
			return mav;
		}
		mav.setViewName("account/activation");
		initStatus(mav);
		mav.addObject("email", email);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/activation/mail/resend")
	public Map<String,String> resend(@RequestParam("email") String email){
		
		Map<String, String> ret = new HashMap<String, String>();
		Map<String, Object> map = userService.updateActivationKey(email);
		ret.put("status", (String) map.get("status"));
		if (Property.SUCCESS_ACCOUNT_ACTIVATION_KEY_UPD.equals((String) map
				.get("status"))) {
			mailService.sendAccountActivationEmail(email,
					(String) map.get("activationKey"));
			ret.put("status", Property.SUCCESS_ACCOUNT_ACTIVATION_EMAIL_RESEND);
		}
		System.out.println("status is"+ret.get("status"));
		return ret;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		Map<String, Object> ret = userService.login(email, password);
		String status = (String) ret.get("status");
		if (Property.SUCCESS_ACCOUNT_LOGIN.equals(status)) {
			session.setAttribute("user",ret.get("user"));
			//session.setAttribute("user_name",ret.get("user_name"));
		}
		return ret;
	}

	private void initStatus(ModelAndView mav) {
		mav.addObject("ERROR_ACCOUNT_ACTIVATION_NOTEXIST",
				Property.ERROR_ACCOUNT_ACTIVATION_NOTEXIST);
		mav.addObject("ERROR_ACCOUNT_ACTIVATION_EXPIRED",
				Property.ERROR_ACCOUNT_ACTIVATION_EXPIRED);
		mav.addObject("ERROR_ACCOUNT_ACTIVATION",
				Property.ERROR_ACCOUNT_ACTIVATION);
	}
	

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}