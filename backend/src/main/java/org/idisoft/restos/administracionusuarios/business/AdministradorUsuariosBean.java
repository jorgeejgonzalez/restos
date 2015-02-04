package org.idisoft.restos.administracionusuarios.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.validation.ValidationException;

import javax.security.sasl.AuthenticationException;
import org.idisoft.restos.administracionusuarios.AdministradorUsuarios;
import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.repository.UsuariosRepository;

@RequestScoped
public class AdministradorUsuariosBean implements AdministradorUsuarios {
	
	private UsuarioDTOFactory usuarioDTOsFactory;
	private UsuariosRepository usuariosRepository;
	
	
	public AdministradorUsuariosBean()
	{
		
	}
	
	@Inject
	public AdministradorUsuariosBean(final UsuarioDTOFactory usuarioDTOsFactory,
			final UsuariosRepository usuariosRepository)
	{
		this.usuarioDTOsFactory=usuarioDTOsFactory;
		this.usuariosRepository=usuariosRepository;
	}

	@Override
	public Usuario auntenticarUsuario(String email, String password)
			throws NoResultException, IllegalArgumentException,
			AuthenticationException 
	{
		if(email==null || email.isEmpty() || password==null || password.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		
		Usuario usuarioParaAutenticar=usuariosRepository.findByEmail(email);
		
		if(!usuarioParaAutenticar.getPassword().equals(password))
		{
			throw new javax.security.sasl.AuthenticationException();
		}
		
		return usuarioDTOsFactory.copyEntity(usuarioParaAutenticar);
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario)
			throws EntityExistsException, IllegalArgumentException 
	{		
		try
		{
			if(usuario==null)
			{
				throw new ValidationException();
			}
			
			Usuario usuarioRegistrado=usuariosRepository.add(usuario);
			
			return usuarioDTOsFactory.copyEntity(usuarioRegistrado);
		}
		catch(ValidationException ex)
		{
			throw new IllegalArgumentException();
		}
	}

}
