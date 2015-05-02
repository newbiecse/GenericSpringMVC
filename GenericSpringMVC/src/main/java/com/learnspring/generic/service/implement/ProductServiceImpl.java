package com.learnspring.generic.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.generic.dao.interfaces.ProductDao;
import com.learnspring.generic.model.Product;
import com.learnspring.generic.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDao productDAO;

	public void setProductDAO(ProductDao personDao) {
		this.productDAO = personDao;
	}

	@Override
	@Transactional
	public void add(Product p) {
		this.productDAO.save(p);
	}

	@Override
	@Transactional
	public void update(Product p) {
		this.productDAO.update(p);
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		return this.productDAO.findAll();
	}

	@Override
	@Transactional
	public Product getById(int id) {
		return this.productDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.productDAO.delete(id);
	}
}
