package cn.edu.test;

import org.junit.Test;

import cn.edu.dao.LoginDao;
import cn.edu.domain.User;

public class LoginDaoTest extends BaseSpring{
	@Test
	public void testLoginDao(){
		LoginDao dao = (LoginDao) applicationContext.getBean("loginDao");
		User user = dao.getUserByUsernameAndPassword("aaaa", "1111");
		System.out.println(user);
	}
}
