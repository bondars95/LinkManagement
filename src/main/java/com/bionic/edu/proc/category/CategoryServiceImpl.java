package com.bionic.edu.proc.category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class CategoryServiceImpl implements CategoryService {
	@Inject
	private CategoryDao categoryDao;

	@Transactional
	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}

	@Override
	public Category findByCategoryName(String name) {
		return categoryDao.findByCategoryName(name);
	}

	public List<Category> showListCategories() {
		return categoryDao.showListCategories();
	}

}
