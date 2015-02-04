package org.idisoft.restos.data;

import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Dependent
public class EntityValidator<T extends Registro> {
	
	private ValidatorFactory validatorfactory;
	private Set<ConstraintViolation<T>> violations;
	
	
	@Inject
	public EntityValidator(ValidatorFactory validatorfactory)
	{
		this.validatorfactory=validatorfactory;
	}
	
	public void validate(T entity)
	{
		Validator validator=validatorfactory.getValidator();
		violations=validator.validate(entity);
	}
	
	public boolean isValid()
	{
		if(violations==null)
			return false;
		
		return violations.isEmpty();
	}
	

}
