package com.learnspring.generic.dao.interfaces;

import java.util.List;

import com.learnspring.generic.model.Product;

public interface ProductDao {

	public Product save(Product p);
	public void update(Product p);
	public List<Product> findAll();
	public Product getById(int id);
	public void delete(int id);
}
