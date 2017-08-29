package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

@Service
@Transactional
public abstract class AbstractDAO<E extends FNEntity, ID extends Serializable> implements EntityDAO<E, ID> {

	private final Class<E> persistentClass;

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Iterable<E> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(this.persistentClass);
		Root<E> rootEntry = cq.from(this.persistentClass);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = this.entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	public E findById(ID id) {
		return entityManager.find(persistentClass, id);
	}
		
//	@SuppressWarnings("unchecked")
//	public Iterable<E> findByIds(Iterable<ID> ids) {
//		return (Iterable<E>) entityManager.find(persistentClass, ids);
//	}

	public E save(E e) {
		entityManager.persist(e);
		return e;
	}

	public Iterable<E> saveAll(Iterable<E> es) {
		entityManager.persist(es);
		return es;
	}

	public E update(E e) {
		return entityManager.merge(e);
	}

	public Iterable<E> update(Iterable<E> es) {
		return entityManager.merge(es);
	}

	public void remove(E e) {
		entityManager.remove(e);
	}
}
