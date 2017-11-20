package cn.edu.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.edu.dao.PersonDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Person;
@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao<Person> {
	
	
	public void savePerson(Person person) {
		this.saveEntry(person);
	}

	public Person getPersonById(Serializable id) {
//		Person person = this.getHibernateTemplate().get(Person.class, id);
//		System.out.println(person.getPname());
		Person person = getEntryById(id);
		return person;
	}

}
