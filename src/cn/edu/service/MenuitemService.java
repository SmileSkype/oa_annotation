package cn.edu.service;

import java.util.Collection;

import cn.edu.domain.Menuitem;

public interface MenuitemService {
	public Collection<Menuitem> getAllMenuitem();
	public Collection<Menuitem> getMenuitemByParentId(Long pid);
}
