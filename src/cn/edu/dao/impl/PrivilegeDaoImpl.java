package cn.edu.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import cn.edu.dao.PrivilegeDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Menuitem;
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Menuitem> implements PrivilegeDao<Menuitem> {

	public Collection<Menuitem> getAllMenuitem() {
		return (Collection<Menuitem>) this.hibernateTemplate.find("from Menuitem m left join fetch m.users u");
	}
	
}
