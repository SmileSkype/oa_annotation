package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;

public interface MenuitemDao<T> extends BaseDao<T>{
	
	public Collection<T> getAllMenuitem();
}
