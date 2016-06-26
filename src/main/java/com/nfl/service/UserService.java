package com.nfl.service;

import java.net.URLDecoder;
import java.util.Map;

import com.nfl.pojo.NflUsersCustom;

public interface UserService {
	public String register(NflUsersCustom user, Map<String, String> map) throws Exception;
	public String activateUser(String email, String key) throws Exception;
	public Map<String, Object> updateActivationKey(String email);

}