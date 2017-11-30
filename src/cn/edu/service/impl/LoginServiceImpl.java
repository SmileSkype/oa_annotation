package cn.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.dao.LoginDao;
import cn.edu.domain.User;
import cn.edu.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="loginDao")
	private LoginDao loginDao;
	public User getUserByUsernameAndPassword(String username, String password) {
		return loginDao.getUserByUsernameAndPassword(username, password);
	}
}
