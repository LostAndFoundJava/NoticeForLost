package com.nfl.serviceImp;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfl.mapper.NflUsersMapper;

import com.nfl.pojo.NflUsers;
import com.nfl.pojo.NflUsersCustom;
import com.nfl.pojo.NflUsersExample;
import com.nfl.service.UserService;
import com.nfl.util.CipherUtil;
import com.nfl.util.Property;
import com.nfl.util.UserDic;

@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	private NflUsersMapper userDao;
	
	@Override
	public String register(NflUsersCustom user, Map<String, String> map) throws Exception {
		String email=user.getUserEmail();
		String username=user.getUserName();
		String password=user.getUserPwd();
		String confirmPwd=user.getConfirmPwd();
		if(email == null || email.length() <= 0){
            return Property.ERROR_EMAIL_EMPTY;
        }else{
            //4 ValidateEmail
            if(!ValidateEmail(email))
                return Property.ERROR_EMAIL_FORMAT;
            //5 email exist?
            NflUsers exist_user = findByEmail(email);
            
            if(exist_user!= null) {
            	
                //6 user status check
                if(UserDic.STATUS_USER_NORMAL == exist_user.getUserStatus()){
                    return Property.ERROR_ACCOUNT_EXIST;
                }else if(UserDic.STATUS_USER_INACTIVE == exist_user.getUserStatus()){
                    map.put("activationKey", URLEncoder.encode(
                    		exist_user.getUserActivationkey(),"UTF-8"));
                    return Property.ERROR_ACCOUNT_INACTIVE;
                }else if(UserDic.STATUS_USER_LOCK == exist_user.getUserStatus()){
                    return Property.ERROR_ACCOUNT_LOCK;
                }
            }           
        }
        
        if(username == null || username.length() == 0) 
            return Property.ERROR_USERNAME_EMPTY;
        else {
            //username exist check
            if(findByUsername(username) != null) {
                return Property.ERROR_USERNAME_EXIST;
            }
        }
        
        
        if(password == null || password.length() <= 0)
            return Property.ERROR_PWD_EMPTY;
        else {
            //3 password format validate
            String vpf_rs = CipherUtil.validatePasswordFormat(password);
            if(vpf_rs != Property.SUCCESS_PWD_FORMAT)
                return vpf_rs;
        }
        
        if(confirmPwd == null || confirmPwd.length() <= 0)
            return Property.ERROR_CFMPWD_EMPTY;
                
        //2 pwd == conformPwd ?
        if(!password.equals(confirmPwd))
            return Property.ERROR_CFMPWD_NOTAGREE;
                    
        user.setUserAvatar(UserDic.DEFAULT_USER_AVATAR);
        user.setUserStatus(UserDic.STATUS_USER_INACTIVE);
      
        String activationKey = CipherUtil.generateActivationUrl(email, password);
        user.setUserActivationkey(activationKey);
        
        int id =userDao.insert(user);
        
        map.put("id", String.valueOf(id));
        map.put("activationKey", URLEncoder.encode(activationKey,"UTF-8"));
        return Property.SUCCESS_ACCOUNT_REG;
        
    }
	 private Object findByUsername(String username) {
		 NflUsersExample nue=new NflUsersExample();
		 NflUsersExample.Criteria nuec=nue.createCriteria();
		 nuec.andUserNameEqualTo(username);
		 List<NflUsers> users=userDao.selectByExample(nue);
		 if(users.size()!=0)
			 return users.get(0);
		return null;
	}
	public NflUsers findByEmail(String email) {
		 NflUsersExample nue=new NflUsersExample();
		 NflUsersExample.Criteria nuec=nue.createCriteria();
		 nuec.andUserEmailEqualTo(email);
		 List<NflUsers> users=userDao.selectByExample(nue);
		 System.out.println(users.toString());
		 if(users.size()!=0)
			 return users.get(0);
	     return null;
	    }
	 
	 private boolean ValidateEmail(String email) {
			boolean result = true;
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
			} catch (AddressException e) {
				result = false;
			}
			return result;
		}
	@Override
	public String activateUser(String email, String key) throws Exception {
		NflUsers user = findByEmail(email);
		if(user == null)
			return Property.ERROR_ACCOUNT_ACTIVATION_NOTEXIST;
		else {
			
			if(user.getUserStatus() == UserDic.STATUS_USER_INACTIVE ){
				if(user.getUserActivationkey().equals(key)){
					user.setUserActivationkey(null);
					user.setUserStatus(UserDic.STATUS_USER_NORMAL);
					userDao.updateByPrimaryKey(user);

				}else {
					return Property.ERROR_ACCOUNT_ACTIVATION_EXPIRED;
				}
			} else{
				if(user.getUserStatus() == UserDic.STATUS_USER_NORMAL){
					return Property.ERROR_ACCOUNT_EXIST;
				} else{
					return Property.ERROR_ACCOUNT_ACTIVATION;
				}
				
			}
		}
		return Property.SUCCESS_ACCOUNT_ACTIVATION;
	}
	@Override
	public Map<String, Object> updateActivationKey(String email) {
		NflUsers user = findByEmail(email);
		String status = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if(user == null){
			status = Property.ERROR_EMAIL_NOT_REG;
		}
		
		if(UserDic.STATUS_USER_INACTIVE == user.getUserStatus()){
			//2 gen activation key
			String activationKey = CipherUtil.generateActivationUrl(email, new Date().toString());
			//update the activationKey in databese
			user.setUserActivationkey(activationKey);
			NflUsersExample nue=new NflUsersExample();
			NflUsersExample.Criteria nuec=nue.createCriteria();
			nuec.andUserEmailEqualTo(email);
			userDao.updateByExampleSelective(user,nue);
	
			status = Property.SUCCESS_ACCOUNT_ACTIVATION_KEY_UPD;
			map.put("activationKey", activationKey);
		} else {
			if(UserDic.STATUS_USER_NORMAL == user.getUserStatus())
				status = Property.ERROR_ACCOUNT_EXIST; //已激活
		}
		map.put("status", status);
		return map;
	}

}
