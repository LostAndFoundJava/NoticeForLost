package com.nfl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nfl.pojo.NflUsers;
import com.nfl.pojo.NflUsersCustom;
import com.nfl.service.MailService;
import com.nfl.serviceImp.UserServiceImp;
import com.nfl.util.Property;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
    private UserServiceImp userService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
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
	
}