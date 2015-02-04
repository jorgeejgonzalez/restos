package org.idisoft.restos.rest;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.security.sasl.AuthenticationException;
import org.idisoft.restos.administracionusuarios.AdministradorUsuarios;
import org.idisoft.restos.model.Usuario;

public class UsuariosServiceRest extends AbstractRestService  implements UsuariosService {
	
	private AdministradorUsuarios administradorUsuarios;
	
	public UsuariosServiceRest()
	{
		
	}
	
	@Inject
	public UsuariosServiceRest(final AdministradorUsuarios administradorUsuarios)
	{
		this.administradorUsuarios = administradorUsuarios;
	}

	@Override
	public Response authenticateUsuario(final String login, final String password) 
	{
		Response serviceResponse = null;
		
		try
		{
			Object entity = administradorUsuarios.auntenticarUsuario(login, password);
			serviceResponse = buildResponse(Status.OK, entity);
		}
		catch(IllegalArgumentException exception)
		{
			serviceResponse = buildResponse(Status.NOT_ACCEPTABLE, exception.getMessage());
		}
		catch(NoResultException exception)
		{
			serviceResponse = buildResponse(Status.NOT_FOUND, exception.getMessage());
		}
		catch(AuthenticationException exception)
		{
			serviceResponse = buildResponse(Status.UNAUTHORIZED, exception.getMessage());
		}
		
		return serviceResponse;
		
	}

	@Override
	public Response registerUsuario(final Usuario usuario) 
	{
		Response serviceResponse = null;
		
		try
		{
			Object entity = administradorUsuarios.registrarUsuario(usuario);
			serviceResponse = buildResponse(Status.CREATED, entity);		
		}
		catch(IllegalArgumentException exception)
		{
			serviceResponse = buildResponse(Status.NOT_ACCEPTABLE, exception.getMessage());
		}
		catch(EntityExistsException exception)
		{
			serviceResponse = buildResponse(Status.CONFLICT, exception.getMessage());
		}		
		
		return serviceResponse;
	}

}
