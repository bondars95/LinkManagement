package com.bionic.edu.proc.category;

import java.util.List;

public interface CategoryService {
	public void saveCategory(Category category);

	public Category findByCategoryName(String name);

	public List<Category> showListCategories();
}
