package cn.edu.service.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.dao.PrivilegeDao;
import cn.edu.domain.Menuitem;
import cn.edu.domain.User;
import cn.edu.service.PrivilegeService;
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	public Collection<Menuitem> getAllMenuitem(Long uid) {
		return privilegeDao.getAllMenuitem(uid);
	}
	public Set<Menuitem> getMenuitemByPIDS(Long[] ids) {
		return privilegeDao.getMenuitemByIDS(ids);
	}
	public Collection<Menuitem> showMenuitemByUser(User user) {
		return privilegeDao.showMenuitemByUser(user);
	}

}
