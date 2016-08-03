package com.bionic.edu.relation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class RelationLinkCategoryDaoImpl implements RelationLinkCategoryDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveRelation(RelationLinkCategory relation) {
		em.persist(relation);
	}
}
