package org.idisoft.restos.data;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.ValidatorFactory;

public class CDIPersistenceResources {
	
	@Produces
    @PersistenceContext
    private EntityManager entityManager;
	
	@Produces
	private ValidatorFactory validatorFactory;
	
	@Produces
	public CriteriaBuilder getCriteriaBuilder()
	{
		return entityManager.getCriteriaBuilder();
	}
	
	
	
}
