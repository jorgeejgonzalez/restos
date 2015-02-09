package org.idisoft.restos.test.unit.data.factory.dto.usuario;

import static org.junit.Assert.*;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTOFactory;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDTOFactoryCopyEntityTest {
	
	private UsuarioDTOFactory factory;
	private Usuario validusuario;
	private Usuario usuariotest;
	
	@Before
	public void instantiateFactory()
	{
		factory=new UsuarioDTOFactory();
		validusuario=TestEntitiesFactory.validUsuario();
		usuariotest=factory.copyEntity(validusuario);
	}

	@Test
	public void CopyEntity_DefaultInvocation_UsuarioDTO() 
	{
		assertTrue(usuariotest instanceof UsuarioDTO);
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameCedula()
	{
		assertEquals(validusuario.getCedula(), usuariotest.getCedula());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_PasswordRestricted()
	{
		assertEquals(UsuarioDTOFactory.RESTRICTED_PASSWORD, usuariotest.getPassword());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameNombre()
	{
		assertEquals(validusuario.getNombre(), usuariotest.getNombre());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameApellido()
	{
		assertEquals(validusuario.getApellido(), usuariotest.getApellido());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameDireccion()
	{
		assertEquals(validusuario.getDireccion(), usuariotest.getDireccion());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameTelefono()
	{
		assertEquals(validusuario.getTelefono(), usuariotest.getTelefono());
	}
	
	@Test
	public void CopyEntity_DefaultInvocation_SameTipo()
	{
		assertEquals(validusuario.getTipo(), usuariotest.getTipo());
	}

}
