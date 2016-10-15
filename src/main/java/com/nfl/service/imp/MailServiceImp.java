package com.nfl.service.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.nfl.pojo.NflUsers;
import com.nfl.service.MailService;

@Service("mailService")
public class MailServiceImp implements MailService {
	 @Autowired
	 private JavaMailSenderImpl mailSender;
	 
	 public static String MAIL_FROM;
	 private static String ACTIVATE_CONTEXT;
	 
	 static{
			String classpath = MailService.class.getClassLoader().getResource("").getPath();
			Properties prop = new Properties();  
			try {
				InputStream in = new FileInputStream(classpath+"/property.properties");  
				prop.load(in);
				MAIL_FROM = prop.getProperty("mail.from");
				ACTIVATE_CONTEXT="http://"+prop.getProperty("domain.name")
								+(prop.getProperty("domain.port")==null?null:":"+prop.getProperty("domain.port"))
								+(prop.getProperty("context")==null?null:prop.getProperty("context"))+
								"/account/activation/";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 
	 
	 
	@Override
	public void sendAccountActivationEmail(String to, String key) {
    	
    	sendMail(to, "账户激活", ACTIVATE_CONTEXT+key+"?email="+to);
		
	}

	@Override
	public void sendResetPwdEmail(String to, String key) {
		// TODO Auto-generated method stub
		
	}
	
	private void sendMail(String to, String subject, String body) {
    	MimeMessage mail = mailSender.createMimeMessage();	
    	try {
    		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setFrom(MAIL_FROM);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    	
    }



}
