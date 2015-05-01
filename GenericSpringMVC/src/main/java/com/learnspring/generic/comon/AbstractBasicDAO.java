package com.learnspring.generic.comon;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

public abstract class AbstractBasicDAO<ENTITY, ID extends Serializable>
		implements BasicDAO<ENTITY, ID>{

	protected final Log log = LogFactory.getLog(getClass());

	private Class<ENTITY> persistentClass;
	private Session session;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	

	public AbstractBasicDAO() {
		persistentClass = (Class<ENTITY>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void delete(ENTITY entity) {
		getSession().delete(entity);
	}

	public List<ENTITY> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public ENTITY get(ID id) {
		ENTITY entity = null;
		entity = (ENTITY) getSession().get(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public ENTITY load(ID id) {
		ENTITY entity = null;
		entity = (ENTITY) getSession().load(getPersistentClass(), id);
		return entity;
	}

	public ENTITY save(ENTITY entity) {
		getSession().save(entity);
		return entity;
	}

	public void update(ENTITY entity) {
		getSession().update(entity);
	}

	public void evict(ENTITY entity) {
		getSession().evict(entity);
	}

	public Criteria createCriteria() {
		return getSession().createCriteria(getPersistentClass());
	}

	public Criteria createCriteria(String alias) {
		return getSession().createCriteria(getPersistentClass(), alias);
	}

	public Class<ENTITY> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<ENTITY> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Session getSession() {
//		return session;
		if(this.sessionFactory != null) {
			return this.sessionFactory.getCurrentSession();
		}
		return null;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	protected List<ENTITY> findByCriteria(Criterion... criterion) {
//		Criteria crit = getSession().createCriteria(getPersistentClass());
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(getPersistentClass());
		
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	public void clear() {
		if (session != null)
			session.clear();

	}

	public void flush() {
		if (session != null)
			session.flush();
	}

	public SQLQuery executeSQLQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public void beginTransaction() {
		if (session != null && session.getTransaction() != null
				&& !session.getTransaction().isActive()) {
			session.getTransaction().begin();
			return;
		} else if (session != null && session.getTransaction() != null
				&& session.getTransaction().isActive())
			return;
		else if (session != null)
			session.beginTransaction();
	}

	public void rollback() {
		try {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} catch (Exception e) {
			// no need write to log
		}
	}

	public void closeSession() {
		try {
			if (session != null && session.isOpen())
				session.close();
		} catch (Exception e) {
			// no need write to log
		}
	}

	public void openSession() {
		session = this.session.getSessionFactory().openSession();
	}


//	public javax.persistence.Query createQuery(String hql) {
//		return getSession().createQuery(hql);
//	}

	public SQLQuery createSQLQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}

	public void beginTransaction(Session session) {
		if (session != null)
			session.beginTransaction();
	}

	public void clear(Session session) {
		if (session != null)
			session.clear();
	}

	public void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
	}

	public void commit(Transaction tx) {
		if (tx != null)
			tx.commit();
	}

	public void commit(Session session) {
		if (session != null && session.getTransaction() != null)
			session.getTransaction().commit();
	}

	public void flush(Session session) {
		if (session != null)
			session.flush();
	}

	public void rollback(Transaction tx) {
		if (tx != null)
			tx.rollback();
	}

	public void rollback(Session session) {
		if (session != null && session.getTransaction() != null)
			session.getTransaction().rollback();
	}


	public SessionFactory getSessionFactory() {
		return this.session.getSessionFactory();
	}
}
