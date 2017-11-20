package cn.edu.test;

import org.junit.Test;

import cn.edu.domain.Department;
import cn.edu.service.DepartmentService;

public class DepartmentServiceTest extends BaseSpring{
	@Test
	public void testDepartmentService(){
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
		@SuppressWarnings("unused")
		Department department = departmentService.getDepartmentById(1L);
	}
}
