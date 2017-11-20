package cn.edu.test;

import java.util.Collection;

import org.junit.Test;

import cn.edu.domain.User;
import cn.edu.service.UserService;

public class UserServiceTest extends BaseSpring{
	@Test
	public void testUserService(){
		UserService userService = (UserService) applicationContext.getBean("userService");
		Collection<User> userList = userService.getAllUser();
		
	}
}
