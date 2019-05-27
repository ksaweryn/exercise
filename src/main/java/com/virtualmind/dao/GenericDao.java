package com.virtualmind.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao <T, I extends Serializable> {

	@PersistenceContext(name = "ExercisePU")
	protected EntityManager em;
	
	public GenericDao() {
	}
	
	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public T findById(Class<T> entity, I id) {
		return em.find(entity, id);
	}

	public void delete(T entity) {
		em.remove(entity);
	}
	
}
