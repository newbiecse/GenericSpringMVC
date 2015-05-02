package com.learnspring.generic.service.interfaces;

import java.util.List;

import com.learnspring.generic.model.Person;
import com.learnspring.generic.model.Product;


public interface ProductService {
	public void add(Product p);
	public void update(Product p);
	public List<Product> findAll();
	public Product getById(int id);
	public void delete(int id);
}
