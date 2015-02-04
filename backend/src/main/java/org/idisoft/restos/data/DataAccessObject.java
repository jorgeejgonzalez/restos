package org.idisoft.restos.data;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Dependent
public class DataAccessObject<T extends Registro> {

	private final EntityManager entitymanager;
	
	private Class<T> entityclass;
	
	@Inject
	public DataAccessObject(final EntityManager entitymanager)
	{
		this.entitymanager=entitymanager;
	}
	
	public void setEntityClass(Class<T> entityclass)
	{
		this.entityclass=entityclass;
	}
	
	public Filter createFilter(String key, Object value)
	{
		return this.new Filter(key,value);
	}
	
	public T persist(T entity) throws EntityExistsException
	{
		entitymanager.persist(entity);
		return entity;
	}
	
	public CriteriaBuilder getCriteriaBuilder()
	{
		return entitymanager.getCriteriaBuilder();
	}
	
	public CriteriaQuery<T> getCriteriaQuery()
	{
		return entitymanager.getCriteriaBuilder().createQuery(entityclass);
	}
	
	public T findByIntKey(int key)
	{
		T entity=entitymanager.find(entityclass, key);
		
		if(entity==null || entity.getEstatusRegistro()==EstatusRegistro.ELIMINADO)
		{
			throw new NoResultException();
		}
		
		return entity;
	}
	
	public T findByStringKey(String key) throws NoResultException
	{
		T entity=entitymanager.find(entityclass, key);
		
		if(entity==null || entity.getEstatusRegistro()==EstatusRegistro.ELIMINADO)
		{
			throw new NoResultException();
		}
		
		return entity;
	}
	
	public T findSingle(Filter datafilter) throws NoResultException
	{
		CriteriaBuilder criteriabuilder=entitymanager.getCriteriaBuilder();
		CriteriaQuery<T> query=criteriabuilder.createQuery(entityclass);
		Root<T> root=query.from(entityclass);
		
		Predicate conditionfilter=criteriabuilder.equal(
				root.get(datafilter.getKey()),
				datafilter.getValue());
		Predicate conditionactive=criteriabuilder.equal(
				root.get("estatusregistro"), 
				EstatusRegistro.ACTIVO);
		Predicate condition=criteriabuilder.and(
				conditionfilter,
				conditionactive);
		
		query=query.select(root);
		query=query.where(condition);
		
		TypedQuery<T> typedquery= entitymanager.createQuery(query);
	
		return typedquery.getSingleResult();
	}
	
	public TypedQuery<T> getTypedQuery(final CriteriaQuery<T> criteriaquery) throws NoResultException
	{
		return entitymanager.createQuery(criteriaquery);
	}

	public class Filter
	{
		private final String key;
		private final Object value;
		
		public Filter(String key, Object value)
		{
			this.key=key;
			this.value=value;
		}
		
		public  String getKey()
		{
			return key;
		}
		
		public Object getValue()
		{
			return value;
		}
		
	}
}
