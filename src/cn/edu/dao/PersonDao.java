package cn.edu.dao;

import java.io.Serializable;

import cn.edu.dao.base.BaseDao;
import cn.edu.domain.Person;

public interface PersonDao<T> extends BaseDao<T>{
	public void savePerson(Person person);
	public Person getPersonById(Serializable id);
}
