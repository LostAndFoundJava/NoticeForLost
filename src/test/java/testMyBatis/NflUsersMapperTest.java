package testMyBatis;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nfl.pojo.NflPostsPanel;
import com.nfl.dao.PostDao;

public class NflUsersMapperTest {
	private PostDao us;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		us=(PostDao)ac.getBean("postDao");
	}

	@Test
	public void test() {
				us.queryById(Integer.valueOf(1)); 
	}

}
