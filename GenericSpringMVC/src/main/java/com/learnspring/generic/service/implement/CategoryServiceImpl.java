package com.learnspring.generic.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.generic.dao.interfaces.CategoryDao;
import com.learnspring.generic.model.Category;
import com.learnspring.generic.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDAO;

	public void setCategoryDAO(CategoryDao categoryDao) {
		this.categoryDAO = categoryDao;
	}

	@Override
	@Transactional
	public void add(Category p) {
		this.categoryDAO.save(p);
	}

	@Override
	@Transactional
	public void update(Category p) {
		this.categoryDAO.update(p);
	}

	@Override
	@Transactional
	public List<Category> findAll() {
		return this.categoryDAO.findAll();
	}

	@Override
	@Transactional
	public Category getById(int id) {
		return this.categoryDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.categoryDAO.delete(id);
	}
}
