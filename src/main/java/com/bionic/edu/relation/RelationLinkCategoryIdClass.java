package com.bionic.edu.relation;

import java.io.Serializable;

public class RelationLinkCategoryIdClass implements Serializable {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + linkId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationLinkCategoryIdClass other = (RelationLinkCategoryIdClass) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (linkId != other.linkId)
			return false;
		return true;
	}

	private int linkId;
	private String categoryName;
}
