package com.learnspring.generic.dao.interfaces;

import java.util.List;

import com.learnspring.generic.model.Person;

public interface PersonDao {

	public Person save(Person p);
	public void update(Person p);
	public List<Person> findAll();
	public Person getById(int id);
	public void delete(int id);
}
