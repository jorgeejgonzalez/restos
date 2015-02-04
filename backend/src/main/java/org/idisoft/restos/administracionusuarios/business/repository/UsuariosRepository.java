package org.idisoft.restos.administracionusuarios.business.repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.validation.ValidationException;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.data.EntityValidator;
import org.idisoft.restos.data.Repository;
import org.idisoft.restos.data.DataAccessObject;

@RequestScoped
public class UsuariosRepository extends Repository<UsuarioEntity> {
	
	
	private UsuarioEntityFactory factory;
	
	public UsuariosRepository()
	{
		this.entityclass=UsuarioEntity.class;
	}
	
	@Inject
	public UsuariosRepository(final DataAccessObject<UsuarioEntity> daousuariojpa,
			final EntityValidator<UsuarioEntity> beanvalidator,
			final UsuarioEntityFactory entityfactory)
	{
		super(daousuariojpa,beanvalidator, entityfactory);		
		this.entityclass=UsuarioEntity.class;
		this.dataAccessObject.setEntityClass(UsuarioEntity.class);
		this.factory=entityfactory;
	}
	
	public Usuario findByCedula(final String cedula) throws NoResultException
	{
		Usuario retorno=dataAccessObject.findByStringKey(cedula);
		return retorno;
	}
	
	public Usuario findByEmail(final String email) throws NoResultException, IllegalArgumentException
	{
		if(email==null || email.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		
		DataAccessObject<UsuarioEntity>.Filter emailfilter=dataAccessObject.createFilter(
				UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, 
				email);
		
		UsuarioEntity retorno=dataAccessObject.findSingle(emailfilter);
		
		return retorno;
	}
	
	public Usuario add(final Usuario usuario) throws ValidationException, EntityExistsException
	{	
		UsuarioEntity entity=factory.copyEntity(usuario);
		
		if(!isValidEntity(entity))
		{
			throw new ValidationException();
		}
		try 
		{
			findByEmail(entity.getEmail());
		}
		catch(NoResultException ex)
		{
			//do nothing
		}
		try
		{
			findByCedula(entity.getCedula());
			throw new EntityExistsException();
		}
		catch(NoResultException ex)
		{
			//do nothing
		}
			
		Usuario retorno=dataAccessObject.persist(entity);
		return retorno;
	}
}
