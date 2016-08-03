package com.bionic.edu.proc.link;

import java.util.List;

import com.bionic.edu.proc.category.Category;

public interface LinkDao {
	public void saveLink(Link link); 

	public void removeLink(int id);

	public Link findById(int id);

	public List<Link> showAll();

	public List<Link> orderBy(String dir, String field);

	public List<Link> findByLang(String lang);

	public List<Link> findByDesc(String keyWords);

	public List<Link> findByIsFinished(String lang);

	public List<Link> findByCategoryName(Category name);

	public List<Link> findByDateBetween(java.sql.Date startDate, java.sql.Date endDate);
}
