package org.idisoft.restos.test.unit.service.usuarios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityExistsException;
import javax.ws.rs.core.Response;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosServiceRegisterUsuarioTest extends AbstractUsuarioServiceTest
{	
	private Usuario validUsuario;
	private Usuario invalidUsuario;	
	
	@Before
	public void setUpInstanciacion()
	{
		instanciacion();
		validUsuario = TestEntitiesFactory.validUsuarioDTO();
		invalidUsuario = TestEntitiesFactory.invalidUsuario(); 
	}
	
	@Test
	public void RegisterUsuario_Success_ResponseCreated()
	{
		when(administradorUsuariosMock.registrarUsuario(validUsuario)
		).thenReturn(validUsuario);
		
		Response responseCheck = usuarioService.registerUsuario(validUsuario);
		
		assertCreated(responseCheck);
	}
	
	@Test
	public void RegisterUsuario_Success_ResponseEntityUsuario()
	{
		when(administradorUsuariosMock.registrarUsuario(validUsuario)
		).thenReturn(validUsuario);
			
		Response responseCheck = usuarioService.registerUsuario(validUsuario);
			
		assertTrue(responseCheck.getEntity() instanceof Usuario);
	}
	
	@Test
	public void RegisterUsuario_UsuarioExists_ResponseConflict()
	{
		when(administradorUsuariosMock.registrarUsuario(validUsuario)
		).thenThrow(new EntityExistsException());
		
		Response responseCheck = usuarioService.registerUsuario(validUsuario);
		
		assertConflict(responseCheck);
	}
	
	@Test
	public void RegisterUsuario_InvalidUsuario_ResponseNotAcceptable()
	{
		when(administradorUsuariosMock.registrarUsuario(invalidUsuario)
		).thenThrow(new IllegalArgumentException());
				
		Response responseCheck = usuarioService.registerUsuario(invalidUsuario);
				
		assertNotAcceptable(responseCheck);
	}
	
	
	
}