package cn.edu.service;

import cn.edu.domain.User;

public interface LoginService {
	public User getUserByUsernameAndPassword(String username,String password);
}
