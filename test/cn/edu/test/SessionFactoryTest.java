package cn.edu.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

@SuppressWarnings("all")
public class SessionFactoryTest extends BaseSpring {
	@Test
	public void sessionFactoryTest(){
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
	}
}
