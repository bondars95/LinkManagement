package com.bionic.edu.proc.category;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface CategoryDao {
	public void saveCategory(Category category);

	public Category findByCategoryName(String Name);

	public List<Category> showListCategories();
}
