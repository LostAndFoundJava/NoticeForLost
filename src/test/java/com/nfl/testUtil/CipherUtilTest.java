package com.nfl.testUtil;

import com.nfl.util.CipherUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cj on 2016/10/15.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"http://www.cnblogs.com/../applicationContext.xml","http://www.cnblogs.com/../daoContext.xml"})
//@TransactionConfiguration(transactionManager="transactionManager")
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
