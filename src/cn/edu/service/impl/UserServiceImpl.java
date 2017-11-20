package cn.edu.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;
import cn.edu.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	public UserDao userDao;
	
	public Collection<User> getAllUser() {
		Collection userList = userDao.getAllUser();
		return userList;
	}

	public User getUserById(Serializable id) {
		return (User) userDao.getEntryById(id);
	}
	
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		userDao.saveEntry(user);
	}
	
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		userDao.updateEntry(user);
	}
	
	@Transactional(readOnly=false)
	public void deleteUserById(Serializable id) {
		userDao.deleteEntryById(id);
	}

}
