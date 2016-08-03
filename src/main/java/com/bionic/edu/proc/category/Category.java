package com.bionic.edu.proc.category;

import java.util.Collection;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.bionic.edu.proc.link.Link;

@Entity
public class Category {
	@NotEmpty(message = "Name can not be empty")
	@Id
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "categories")
	private Collection<Link> links;

	public Collection<Link> getLinks() {
		return links;
	}

	public void setLinks(Collection<Link> links) {
		this.links = links;
	}

	public Category() {
	};
}