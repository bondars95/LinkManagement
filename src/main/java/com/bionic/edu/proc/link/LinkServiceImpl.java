package com.bionic.edu.proc.link;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.proc.category.Category;

@Named
public class LinkServiceImpl implements LinkService {
	@Inject
	private LinkDao linkDao;

	@Transactional
	public void saveLink(Link link) {
		linkDao.saveLink(link);
	}

	@Transactional
	public void removeLink(int id) {
		linkDao.removeLink(id);
	}

	@Override
	public Link findById(int id) {
		return linkDao.findById(id);
	}

	@Override
	public List<Link> showAll() {
		return linkDao.showAll();
	}

	@Override
	public List<Link> orderBy(String dir, String field) {
		return linkDao.orderBy(dir, field);
	}

	@Override
	public List<Link> findByLang(String lang) {
		return linkDao.findByLang(lang);
	}

	@Override
	public List<Link> findByDesc(String keyWords) {
		return linkDao.findByDesc(keyWords);
	}

	@Override
	public List<Link> findByIsFinished(String lang) {
		return linkDao.findByIsFinished(lang);
	}

	@Override
	public List<Link> findByCategoryName(Category name) {
		return linkDao.findByCategoryName(name);
	}

	@Override
	public List<Link> findByDateBetween(java.sql.Date startDate, java.sql.Date endDate) {
		return linkDao.findByDateBetween(startDate, endDate);
	}

}
