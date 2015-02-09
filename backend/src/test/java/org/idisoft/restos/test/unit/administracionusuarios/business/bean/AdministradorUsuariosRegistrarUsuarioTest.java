package org.idisoft.restos.test.unit.administracionusuarios.business.bean;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityExistsException;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorUsuariosRegistrarUsuarioTest extends AbstractAdministradorUsuariosBeanTest {
	
	private Usuario validUsuario;
	private Usuario invalidUsuario;
	
	@Before
	public void setUpInstanciacion()
	{
		instanciacion();
		validUsuario=TestEntitiesFactory.validUsuario();
		invalidUsuario=TestEntitiesFactory.invalidUsuario();
	}
	
	@Before
	public void setUpMockitoRules()
	{
		mockitoRules();
	}
	
	@Test
	public void RegistrarUsuario_Success_ReturnsNotNull() {
		Usuario usuarioCheck=administradorUsuarios.registrarUsuario(validUsuario);
		assertNotNull(usuarioCheck);
	}
	
	@Test
	public void RegistrarUsuario_Success_ReturnsUsuarioDTO() {
		Usuario usuarioCheck=administradorUsuarios.registrarUsuario(validUsuario);
		assertTrue(usuarioCheck instanceof UsuarioDTO);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void RegistrarUsuario_UsuarioNull_ThrowIllegalArgumentException() {
		administradorUsuarios.registrarUsuario(null);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void RegistrarUsuario_InvalidUsuario_ThrowIllegalArgumentException() {
		administradorUsuarios.registrarUsuario(invalidUsuario);		
	}
	
	@Test(expected=EntityExistsException.class)
	public void RegistrarUsuario_UsuarioIsInRepository_ThrowEntityExistsException() {
		when(usuariosRepositoryMock.add(validUsuario)).thenThrow(new EntityExistsException());		
		administradorUsuarios.registrarUsuario(validUsuario);		
	}	

}
