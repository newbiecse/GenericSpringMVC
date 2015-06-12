package com.learnspring.generic.dao.implement;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.learnspring.generic.comon.AbstractBasicDAO;
import com.learnspring.generic.dao.interfaces.ProductDao;
import com.learnspring.generic.model.Product;

@Repository
public class ProductDaoImpl extends AbstractBasicDAO<Product, Integer> implements ProductDao {
	
	@Override
	public List<Product> findAll() {
		Session session = super.getSession();
		@SuppressWarnings("unchecked")
		List<Product> products = session.createCriteria(Product.class)
	    .createCriteria("category")
	    .list();
		return products;
	}

	@Override
	public void update(Product p) {
		super.update(p);
		log.info("Person updated successfully, Person Details="+p);
	}

	@Override
	public Product getById(int id) {
		Product p = super.get(id);
		log.info("Person loaded successfully, Person details="+p);
		return p;
//		return null;
	}

	@Override
	public void delete(int id) {
		Product p = super.load(id);
		if(null != p){
			super.delete(p);
		}
		log.info("Person deleted successfully, person details="+p);
	}
//	@Override
//	public Product save(Product p) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Query createQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}	
}
