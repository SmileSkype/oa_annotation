package cn.edu.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.dao.UserDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
	
	 
	public Collection<User> getAllUser(){
		List<User> userList = (List<User>) this.hibernateTemplate.find("from User u left join fetch u.department d left join fetch u.posts p");
		return new HashSet<User>(userList);
	}
}
