package org.idisoft.restos.administracionusuarios;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.security.sasl.AuthenticationException;

import org.idisoft.restos.model.Usuario;

public interface AdministradorUsuarios {
	
	public Usuario auntenticarUsuario(final String login, final String password) 
	throws NoResultException,IllegalArgumentException, AuthenticationException;
	
	public Usuario registrarUsuario(final Usuario usuario)
	throws EntityExistsException, IllegalArgumentException;

}
