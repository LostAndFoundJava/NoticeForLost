package com.nfl.service;

import java.util.Map;

import com.nfl.pojo.NflUsersCustom;

public interface UserService {
	public String register(NflUsersCustom user, Map<String, String> map) throws Exception;
	
}