package cn.edu.test;

import java.util.Set;

import org.junit.Test;

import cn.edu.dao.PrivilegeDao;

@SuppressWarnings("rawtypes")
public class PrivilegeDaoTest extends BaseSpring{
	@Test
	public void testPrivilege(){
		PrivilegeDao dao = (PrivilegeDao) applicationContext.getBean("privilegeDao");
		Long[] mids = {1L,2L,3L,4L};
		Set set = dao.getMenuitemByIDS(mids);
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
