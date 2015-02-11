package org.idisoft.restos.test.unit.service.usuarios;

import static org.mockito.Mockito.*;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;

import javax.security.sasl.AuthenticationException;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosServiceAuthenticateUsuarioTest extends AbstractUsuarioServiceTest
{
	private String testEmail;
	private String testPassword;
	
	@Before
	public void setUpInstanciacion()
	{
		instanciacion();
		testEmail=TestEntitiesFactory.VALID_EMAIL;
		testPassword=TestEntitiesFactory.VALID_PASSWORD;
	}	
	
	
	@Test
	public void AuthenticateUsuario_Success_ReturnsResponseOK() throws Exception
	{
		when(administradorUsuariosMock.auntenticarUsuario(
				TestEntitiesFactory.VALID_EMAIL,
				TestEntitiesFactory.VALID_PASSWORD)
		).thenReturn(TestEntitiesFactory.validUsuario());
		
		Response responseCheck = usuarioService.authenticateUsuario(testEmail, testPassword);
		assertOK(responseCheck);		
	}
	
	@Test
	public void AuthenticateUsuario_InvalidLogin_ReturnsResponseNotAcceptable() throws Exception
	{
		when(administradorUsuariosMock.auntenticarUsuario(
				"", 
				TestEntitiesFactory.VALID_PASSWORD)
		).thenThrow(new IllegalArgumentException());
		
		Response responseCheck = usuarioService.authenticateUsuario("", testPassword);
		assertNotAcceptable(responseCheck);	
	}
	
	@Test
	public void AuthenticateUsuario_InvalidPassword_ReturnsResponseNotAcceptable() throws Exception
	{
		when(administradorUsuariosMock.auntenticarUsuario(
				TestEntitiesFactory.VALID_EMAIL, 
				"")
		).thenThrow(new IllegalArgumentException());
		
		Response responseCheck = usuarioService.authenticateUsuario(testEmail,"");
		assertNotAcceptable(responseCheck);	
	}
	
	@Test
	public void AuthenticateUsuario_LoginNotFound_ReturnsResponseNotFound() throws Exception
	{
		when(administradorUsuariosMock.auntenticarUsuario(
				TestEntitiesFactory.VALID_EMAIL, 
				TestEntitiesFactory.VALID_PASSWORD)
		).thenThrow(new NoResultException());
		
		Response responseCheck = usuarioService.authenticateUsuario(testEmail,testPassword);
		assertNotFound(responseCheck);	
	}
	
	@Test
	public void AuthenticateUsuario_PasswordNoMatch_ReturnsResponseUnauthorized() throws Exception
	{
		when(administradorUsuariosMock.auntenticarUsuario(
				TestEntitiesFactory.VALID_EMAIL, 
				"anything")
		).thenThrow(new AuthenticationException());
		
		Response responseCheck = usuarioService.authenticateUsuario(testEmail,"anything");
		assertUnauthorized(responseCheck);	
	}
	
}
