package cn.edu.test;

import org.junit.Test;

import cn.edu.dao.PersonDao;
import cn.edu.domain.Department;
import cn.edu.domain.Person;
import cn.edu.service.DepartmentService;
import cn.edu.service.PersonService;

public class TransactionTest extends BaseSpring{
	/**
	 * 没有事务环境
	 * 当应用程序调用完Person person = (Person)this.getHibernateTemplate().load(Person.class, 1L);
	 *           session直接关闭了,那么所在的dao方法session不存在了
	 */
	@Test
	public void testHibernateTemplate(){
		PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
		personDao.getPersonById(1L);
	}
	
	/**
	 * 当整个方法有事务环境，当方法调用完以后，session关闭
	 */
	@Test
	public void testService(){
		PersonService personService = (PersonService)applicationContext.getBean("personService");
		Person person = personService.getPersonById(3L);
		System.out.println(person.getPname());
	}
	
	@Test
	public void testDepartmentService(){
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
		Department department = departmentService.getDepartmentById(1L);
	}
}
