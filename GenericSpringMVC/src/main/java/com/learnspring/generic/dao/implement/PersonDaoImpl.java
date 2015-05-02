package com.learnspring.generic.dao.implement;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.learnspring.generic.comon.AbstractBasicDAO;
import com.learnspring.generic.dao.interfaces.PersonDao;
import com.learnspring.generic.model.Person;

@Repository
public class PersonDaoImpl extends AbstractBasicDAO<Person, Integer> implements PersonDao {
	
//	@Override
//	public Person save(Person p) {
//		return super.save(p);
//	}

	@Override
	public void update(Person p) {
		super.update(p);
		log.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {
		List<Person> personsList = super.findAll();
		for(Person p : personsList){
			log.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getById(int id) {
		Person p = super.get(id);
		log.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void delete(int id) {
		Person p = super.load(id);
		if(null != p){
			super.delete(p);
		}
		log.info("Person deleted successfully, person details="+p);
	}

	@Override
	public Query createQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}	
}
