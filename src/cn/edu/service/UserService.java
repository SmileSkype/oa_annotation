package cn.edu.service;

import java.io.Serializable;
import java.util.Collection;

import cn.edu.domain.User;

public interface UserService {
	public Collection<User> getAllUser();
	public User getUserById(Serializable id);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUserById(Serializable id);
	public User getUserByUsername(String username);
}
