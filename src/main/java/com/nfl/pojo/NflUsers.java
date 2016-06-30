package com.nfl.pojo;

import java.util.Date;

import com.nfl.search.Searchable;

public class NflUsers implements Searchable{
    private Integer id;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String userPwd;

    private Date userRegisteredDate;

    private Integer userStatus;

    private String userActivationkey;

    private String userAvatar;

    private String userDesc;

    private String resetpwdKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Date getUserRegisteredDate() {
        return userRegisteredDate;
    }

    public void setUserRegisteredDate(Date userRegisteredDate) {
        this.userRegisteredDate = userRegisteredDate;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserActivationkey() {
        return userActivationkey;
    }

    public void setUserActivationkey(String userActivationkey) {
        this.userActivationkey = userActivationkey == null ? null : userActivationkey.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    public String getResetpwdKey() {
        return resetpwdKey;
    }

    public void setResetpwdKey(String resetpwdKey) {
        this.resetpwdKey = resetpwdKey == null ? null : resetpwdKey.trim();
    }
}