package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;

public interface UserDao<T> extends BaseDao<T> {
	public Collection<T> getAllUser();
}
