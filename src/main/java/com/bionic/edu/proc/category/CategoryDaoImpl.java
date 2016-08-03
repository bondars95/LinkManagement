package com.bionic.edu.proc.category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void saveCategory(Category category) {
		em.persist(category);
	}

	@Override
	public Category findByCategoryName(String Name) {
		Category category = null;
		category = em.find(Category.class, Name);
		return category;
	}

	public List<Category> showListCategories() {
		TypedQuery<Category> query = em.createQuery("SELECT  c FROM Category c", Category.class);
		List<Category> listL = null;
		listL = query.getResultList();
		return listL;
	}

}
