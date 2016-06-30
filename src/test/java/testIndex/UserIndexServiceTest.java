package testIndex;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nfl.pojo.NflUsers;
import com.nfl.search.UserIndexService;

public class UserIndexServiceTest {
	UserIndexService us = null;
	@Before
	public void setUp() throws Exception {
		us = new UserIndexService();
		//testAdd();
	}

	@Test
	public void testAdd() {
		NflUsers user = new NflUsers();
		user.setUserName("cj");
		user.setId(12);
		us.add(user);
	}

	@Test
	public void testFindUserByName() {
		List<Integer> list = us.findUserByName("cj");
		System.out.println(list.size());
		for(Integer i : list){
			System.out.println(i);
		}
	}

}
