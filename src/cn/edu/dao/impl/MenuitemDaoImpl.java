package cn.edu.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import cn.edu.dao.MenuitemDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Menuitem;
@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao<Menuitem>{
	
	/**
	 * 一次性加载树
	 */
	public Collection<Menuitem> getAllMenuitem() {
		return (Collection<Menuitem>) this.hibernateTemplate.find("from Menuitem m left join fetch m.users u");
	}
	
	/**
	 * 点击事件加载树
	 */
	public Collection<Menuitem> getMenuitemByParentId(Long pid) {
		return (Collection<Menuitem>) this.hibernateTemplate.find("from Menuitem where pid = ?", pid);
	}

}
