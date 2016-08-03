package com.bionic.edu.proc.link;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.proc.category.Category;

@Repository
public class LinkDaoImpl implements LinkDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void saveLink(Link link) {
		if (link.getId() == 0) {
			em.persist(link);
		} else {
			em.merge(link);
		}
	}

	@Override
	public void removeLink(int id) {
		Link link = em.find(Link.class, id);
		if (link != null) {
			em.remove(link);
		}
	}

	@Override
	public Link findById(int id) {
		Link link = em.find(Link.class, id);
		if (link != null) {
			return link;
		}
		return null;
	}

	@Override
	public List<Link> showAll() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l", Link.class);
		List<Link> listL = null;
		listL = query.getResultList();
		return listL;
	}

	@Override
	public List<Link> findByLang(String lang) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE l.lang = :lang ", Link.class);
		query.setParameter("lang", lang);
		return query.getResultList();
	}

	@Override
	public List<Link> findByDesc(String keyWords) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE (UPPER(l.description) LIKE :keyWords) OR"
				+ "(UPPER(l.name) LIKE :keyWords) ", Link.class);
		query.setParameter("keyWords", "%" + keyWords.toUpperCase() + "%");
		return query.getResultList();
	}

	@Override
	public List<Link> findByIsFinished(String finish) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l WHERE l.finish = :finish ", Link.class);
		query.setParameter("finish", finish);
		return query.getResultList();
	}

	@Override
	public List<Link> findByDateBetween(java.sql.Date startDate, java.sql.Date endDate) {
		TypedQuery<Link> query = em.createQuery(
				"SELECT l FROM Link l WHERE    (:startDate<=l.created) AND (l.created <=:endDate)  ", Link.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}

	@Override
	public List<Link> orderBy(String dir, String field) {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l ORDER BY " + "l." + field + " " + dir,
				Link.class);
		List<Link> listL = null;
		listL = query.getResultList();
		return listL;
	}

	@Override
	public List<Link> findByCategoryName(Category name) {
		TypedQuery<Link> query = em.createQuery("SELECT l from Link l WHERE :name member of l.categories", Link.class);
		List<Link> listL = null;
		query.setParameter("name", name);
		listL = query.getResultList();
		return listL;
	}

}
