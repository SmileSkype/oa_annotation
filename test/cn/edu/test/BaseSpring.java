package cn.edu.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseSpring {
	
	public static ApplicationContext applicationContext;
	@Before
	public void start(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
}
