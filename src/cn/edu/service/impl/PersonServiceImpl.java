package cn.edu.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dao.PersonDao;
import cn.edu.domain.Person;
import cn.edu.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Transactional(readOnly=false)
	public void savePerson(Person person) {
		personDao.savePerson(person);
	}
	@Transactional(readOnly=false)
	public Person getPersonById(Serializable id) {
		Person person = personDao.getPersonById(id);
		return person;
	}

}
