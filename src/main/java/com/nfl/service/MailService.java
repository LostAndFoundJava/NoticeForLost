package com.nfl.service;

public interface MailService{
	public void sendAccountActivationEmail(String to, String key);
	public void sendResetPwdEmail(String to, String key);
}