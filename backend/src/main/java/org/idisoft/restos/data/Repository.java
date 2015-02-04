package org.idisoft.restos.data;

import org.idisoft.restos.factory.ModelFactory;

public abstract class Repository<T extends Registro> {
	
	protected Class<T> entityclass;
	
	protected DataAccessObject<T> dataAccessObject;
	protected EntityValidator<T> beanValidator;
	protected ModelFactory<T> entityFactory;
	
	public Repository()
	{
	}
	
	public Repository(final DataAccessObject<T> dataaccessobject, 
			final EntityValidator<T> beanvalidator,
			final ModelFactory<T> entityFactory)
	{
		this.dataAccessObject=dataaccessobject;
		this.beanValidator=beanvalidator;
		this.entityFactory=entityFactory;
	}
	
	protected boolean isValidEntity(final T entity)
	{
		beanValidator.validate(entityFactory.copyEntity(entity));
		return beanValidator.isValid();
	}

}
