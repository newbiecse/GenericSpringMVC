package com.learnspring.generic.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.generic.dao.interfaces.PersonDao;
import com.learnspring.generic.model.Person;
import com.learnspring.generic.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	private PersonDao personDAO;

	public void setPersonDAO(PersonDao personDao) {
		this.personDAO = personDao;
	}

	@Override
	@Transactional
	public void add(Person p) {
		this.personDAO.save(p);
	}

	@Override
	@Transactional
	public void update(Person p) {
		this.personDAO.update(p);
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		return this.personDAO.findAll();
	}

	@Override
	@Transactional
	public Person getById(int id) {
		return this.personDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.personDAO.delete(id);
	}
}
