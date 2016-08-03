package com.bionic.edu.relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(RelationLinkCategoryIdClass.class)
public class RelationLinkCategory {

	@Id
	private int linkId;
	@Id
	private String categoryName;

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public RelationLinkCategory() {
	}

	@Override
	public String toString() {
		return "RelationLinkCategory [linkId=" + linkId + ", categoryName=" + categoryName + "]";
	};

}
