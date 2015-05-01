package com.learnspring.generic.comon;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;

public interface BasicDAO<ENTITY, ID extends Serializable> {

	/** save a entity */
	public ENTITY save(ENTITY entity);
	
	/** update a entity */
	public void update(ENTITY entity);
	
	/** delete a entity */
	public void delete(ENTITY entity);
	
	/** load a entity with id */
	public ENTITY load(ID id);
	
	/** get a entity with id */
	public ENTITY get(ID id);
	
	/** list all entitys of table */
	public List<ENTITY> findAll();
	
	/** execute sql statement */
	public SQLQuery executeSQLQuery(String sql);
	
	/** create query from HQL */
	public Query createQuery(String sql);
	
	/** create criteria for an entity */
	public Criteria createCriteria();
	
	public Criteria createCriteria(String alias);
	
	/** evit an entity */
	public void evict(ENTITY entity);
	
	/** get value of a field from class */
	
	
}
