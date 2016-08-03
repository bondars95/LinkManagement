package com.bionic.edu.proc.link;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bionic.edu.proc.category.Category;

@Entity
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "URL can not be empty")
	private String address;
	@NotEmpty(message = "Name can not be empty")
	private String name;
	private String description;
	private java.sql.Date created = java.sql.Date.valueOf(LocalDate.now());
	@NotEmpty(message = "Language can not be empty")
	@Pattern(regexp = "[A-Z][A-Z]")
	private String lang;
	@NotEmpty(message = "Read status can not be empty")
	private String finish;

	@ManyToMany
	@JoinTable(name = "RelationLinkCategory", joinColumns = @JoinColumn(name = "linkId"), inverseJoinColumns = @JoinColumn(name = "categoryName"))
	private List<Category> categories;

	public List<Category> getCategories() {
		return this.categories;
		// return toString(categories);
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Link() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Date getCreated() {
		return created;
	}

	public void setCreated(java.sql.Date created) {
		this.created = created;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	@Override
	public String toString() {

		return "Link [id=" + id + ", address=" + address + ", name=" + name + ", description=" + description
				+ ", created=" + created + ",  +  lang=" + lang + ", finish=" + finish + "]";
	}

}
