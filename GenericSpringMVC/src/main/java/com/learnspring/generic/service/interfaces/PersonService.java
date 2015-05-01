package com.learnspring.generic.service.interfaces;

import java.util.List;

import com.learnspring.generic.model.Person;


public interface PersonService {
	public void add(Person p);
	public void update(Person p);
	public List<Person> findAll();
	public Person getById(int id);
	public void delete(int id);
}
