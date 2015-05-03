package com.learnspring.generic.service.interfaces;

import java.util.List;

import com.learnspring.generic.model.Category;


public interface CategoryService {
	public void add(Category p);
	public void update(Category p);
	public List<Category> findAll();
	public Category getById(int id);
	public void delete(int id);
}
