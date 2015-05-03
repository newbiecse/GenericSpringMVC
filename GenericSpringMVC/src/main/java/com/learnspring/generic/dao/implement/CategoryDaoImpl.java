package com.learnspring.generic.dao.implement;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.learnspring.generic.comon.AbstractBasicDAO;
import com.learnspring.generic.dao.interfaces.CategoryDao;
import com.learnspring.generic.model.Category;
import com.learnspring.generic.model.Product;

@Repository
public class CategoryDaoImpl extends AbstractBasicDAO<Category, Integer> implements CategoryDao {
	


	@Override
	public void update(Category p) {
		super.update(p);
		log.info("Person updated successfully, Person Details="+p);
	}

	@Override
	public Category getById(int id) {
		Category p = super.get(id);
		log.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void delete(int id) {
		Category p = super.load(id);
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
