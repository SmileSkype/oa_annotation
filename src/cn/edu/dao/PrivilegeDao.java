package cn.edu.dao;

import java.util.Collection;
import java.util.Set;

import cn.edu.dao.base.BaseDao;
/**
 * 权限树
 */
import cn.edu.domain.Menuitem;
import cn.edu.domain.User;
public interface PrivilegeDao<T> extends BaseDao<T> {
	public Collection<Menuitem> getAllMenuitem(Long uid);
	public Set<Menuitem> getMenuitemByIDS(Long[] ids);
	public Collection<Menuitem> showMenuitemByUser(User user);
}
