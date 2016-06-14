package testMyBatis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nfl.pojo.NflUsers;
import com.nfl.service.UserService;

public class NflUsersMapperTest {
	private UserService us;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		us=(UserService)ac.getBean("userServiceImp");
	}

	@Test
	public void test() {
		NflUsers user=new NflUsers();
		user.setUserName("cc1");
		us.addUser(user);
	}

}
