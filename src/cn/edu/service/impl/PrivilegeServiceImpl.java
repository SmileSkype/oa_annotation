package cn.edu.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.dao.PrivilegeDao;
import cn.edu.domain.Menuitem;
import cn.edu.service.PrivilegeService;
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	public Collection<Menuitem> getAllMenuitem() {
		return privilegeDao.getAllMenuitem();
	}

}
