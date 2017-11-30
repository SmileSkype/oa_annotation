package cn.edu.dao;

import cn.edu.domain.User;

public interface LoginDao {
	/**
	 * 根据用户名和密码判断用户是否能够登录
	 */
	public User getUserByUsernameAndPassword(String username,String password);
}
