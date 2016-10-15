package com.nfl.testUtil;

import com.nfl.util.CipherUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by cj on 2016/10/15.
 */
public class CipherUtilTest {
    private String passwordChange;
    @Before
    public void generatePasswordTest(){
        passwordChange = CipherUtil.generatePassword("123");
    }
    @Test
    public void validatePasswordTest(){
        boolean bool = CipherUtil.validatePassword(passwordChange,"123");
        System.out.println(bool);
    }
}
