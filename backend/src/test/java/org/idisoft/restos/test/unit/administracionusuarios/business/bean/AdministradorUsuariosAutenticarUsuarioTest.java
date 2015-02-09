package org.idisoft.restos.test.unit.administracionusuarios.business.bean;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.NoResultException;

import javax.security.sasl.AuthenticationException;
import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorUsuariosAutenticarUsuarioTest extends AbstractAdministradorUsuariosBeanTest {
	
	
	private String emailNotInRepository="notest";
	private String emailTest;
	private String passwordTest;	
	
	@Before
	public void setUpInstanciacion()
	{
		instanciacion();
		emailTest=TestEntitiesFactory.VALID_EMAIL;
		passwordTest=TestEntitiesFactory.VALID_PASSWORD;
	}
	
	@Before
	public void setUpMockitoRules()
	{
		mockitoRules();
		when(usuariosRepositoryMock.findByEmail(emailNotInRepository)).thenThrow(new NoResultException());	
	}
	
	@Test
	public void AutenticarUsuario_Success_ReturnsNotNull() throws Exception
	{
		Usuario usuariocheck=administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);
		assertNotNull(usuariocheck);
	}
	
	@Test
	public void AutenticarUsuario_Success_ReturnsUsuarioDTO() throws Exception
	{
		Usuario usuariocheck=administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);
		assertTrue(usuariocheck instanceof UsuarioDTO);
	}

	@Test(expected=IllegalArgumentException.class)
	public void AutenticarUsuario_LoginNull_ThrowIllegalArgumentException() throws Exception 
	{
		emailTest=null;
		administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void AutenticarUsuario_LoginEmpty_ThrowIllegalArgumentException() throws Exception 
	{
		emailTest="";
		administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void AutenticarUsuario_PasswordNull_ThrowIllegalArgumentException() throws Exception
	{
		passwordTest=null;
		administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);
	}
	
	@Test(expected=NoResultException.class)
	public void AutenticarUsuario_LoginNotInRepository_ThrowsNoResultException() throws Exception
	{
		emailTest=emailNotInRepository;
		administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);
	}
	
	@Test(expected=AuthenticationException.class)
	public void AutenticarUsuario_PasswordNoMatch_ThrowsAuthenticationException() throws Exception
	{
		passwordTest="anything";
		administradorUsuarios.auntenticarUsuario(emailTest, passwordTest);
	}
	
	

}
