package com.nfl.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfl.mapper.NflUsersMapper;
import com.nfl.pojo.NflUsers;
import com.nfl.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private NflUsersMapper userDao;
	
	@Override
	public void addUser(NflUsers user) {
		userDao.insert(user);
	}

}
