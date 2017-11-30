package cn.edu.service;

import java.util.Collection;
import java.util.Set;

import cn.edu.domain.Menuitem;
import cn.edu.domain.User;

public interface PrivilegeService {
	public Collection<Menuitem> getAllMenuitem(Long uid);
	public Set<Menuitem> getMenuitemByPIDS(Long[] ids);
	public Collection<Menuitem> showMenuitemByUser(User user);
}
