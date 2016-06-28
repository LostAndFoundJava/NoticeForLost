package com.nfl.service;

import java.util.Map;

public interface MailService{
	public void sendAccountActivationEmail(String to, String key);
	public void sendResetPwdEmail(String to, String key);
}