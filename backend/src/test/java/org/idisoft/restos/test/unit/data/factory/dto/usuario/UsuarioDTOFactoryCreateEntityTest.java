package org.idisoft.restos.test.unit.data.factory.dto.usuario;

import static org.junit.Assert.*;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTOFactory;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDTOFactoryCreateEntityTest {

	private UsuarioDTOFactory factory;
	
	@Before
	public void setUp()
	{
		factory=new UsuarioDTOFactory();
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_UsuarioDTO() {
		Usuario usuariotest=factory.createEntity();
		assertTrue(usuariotest instanceof UsuarioDTO);
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_DefaultCedula()
	{
		String defaultCedula="V00000000";
		Usuario usuariotest=factory.createEntity();
		assertEquals(defaultCedula,usuariotest.getCedula());
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_DefaultPassword()
	{
		String defaultPassword=UsuarioDTOFactory.RESTRICTED_PASSWORD;
		Usuario usuariotest=factory.createEntity();
		assertEquals(defaultPassword,usuariotest.getPassword());
	}
	
	
	

}
