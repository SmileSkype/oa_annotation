package cn.edu.test;

import org.junit.Test;

import cn.edu.domain.Person;
import cn.edu.service.PersonService;

public class PersonTest extends BaseSpring{
	@Test
	public void testPerson(){
		PersonService personService = (PersonService) applicationContext.getBean("personService");
		personService.savePerson(new Person(3L,"xiaowang"));
	}
}
