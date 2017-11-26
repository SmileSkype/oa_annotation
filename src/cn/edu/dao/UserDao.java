package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;
import cn.edu.domain.User;

public interface UserDao<T> extends BaseDao<T> {
	public Collection<T> getAllUser();
	public User getUserByUsername(String username);
}
