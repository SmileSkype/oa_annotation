package cn.edu.service;

import java.io.Serializable;

import cn.edu.domain.Person;

public interface PersonService {
	public void savePerson(Person person);

	public Person getPersonById(Serializable id);
}
