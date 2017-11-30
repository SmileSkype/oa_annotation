package cn.edu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.dao.LoginDao;
import cn.edu.domain.User;
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	public User getUserByUsernameAndPassword(String username,String password) {
		List<User> userList = (List<User>) this.hibernateTemplate.find("from User where username = ? and password = ?", new Object[]{username,password});
		if(userList.size() != 0){
			return userList.get(0);
		}else{
			return null;
		}
	}

}
