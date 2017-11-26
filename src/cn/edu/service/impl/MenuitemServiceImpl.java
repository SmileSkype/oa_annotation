package cn.edu.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.dao.MenuitemDao;
import cn.edu.domain.Menuitem;
import cn.edu.service.MenuitemService;
@Service("menuitemService")
public class MenuitemServiceImpl implements MenuitemService{
	
	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	public Collection<Menuitem> getAllMenuitem() {
//		return menuitemDao.getAllEntry();
		return menuitemDao.getAllMenuitem();
	}
	public Collection<Menuitem> getMenuitemByParentId(Long pid) {
		return menuitemDao.getMenuitemByParentId(pid);
	}

}
