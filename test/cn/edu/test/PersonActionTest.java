package cn.edu.test;

import org.junit.Test;

import cn.edu.action.PersonAction;

public class PersonActionTest extends BaseSpring{
	@Test
	public void testPersonAction(){
		PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
		personAction.savePerson();
	}
}
