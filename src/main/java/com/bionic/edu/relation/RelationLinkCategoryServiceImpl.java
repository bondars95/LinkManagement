package com.bionic.edu.relation;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class RelationLinkCategoryServiceImpl implements RelationLinkCategoryService {
	@Inject
	private RelationLinkCategoryDao relationLinkCategoryDao;

	@Transactional
	public void saveRelation(RelationLinkCategory relation) {
		relationLinkCategoryDao.saveRelation(relation);

	}
}
