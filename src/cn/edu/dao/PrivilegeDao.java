package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;
/**
 * 权限树
 */
import cn.edu.domain.Menuitem;
public interface PrivilegeDao<T> extends BaseDao<T> {
	public Collection<Menuitem> getAllMenuitem();
}
