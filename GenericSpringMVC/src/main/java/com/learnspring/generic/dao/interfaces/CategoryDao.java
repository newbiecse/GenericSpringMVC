package com.learnspring.generic.dao.interfaces;

import java.util.List;

import com.learnspring.generic.model.Category;

public interface CategoryDao {

	public Category save(Category p);
	public void update(Category p);
	public List<Category> findAll();
	public Category getById(int id);
	public void delete(int id);
}
