package com.nfl.serviceImp;

import org.springframework.stereotype.Service;

import com.nfl.service.MailService;

@Service("mailService")
public class MailServiceImp implements MailService {

	@Override
	public void sendAccountActivationEmail(String to, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendResetPwdEmail(String to, String key) {
		// TODO Auto-generated method stub
		
	}

}
