package org.idisoft.restos.test.unit.data.factory.jpa.usuario;

import static org.junit.Assert.*;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityFactory;
import org.junit.Before;
import org.junit.Test;

public class UsuarioEntityFactoryCreateEntityTest {
	
	private UsuarioEntityFactory factory;
	
	private String ceduladefault="V00000000";
	private String logindefault="";
	private String passworddefault="";
	private String nombredefault="";
	
	@Before
	public void instantiateFactory()
	{
		factory=new UsuarioEntityFactory();
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_NotNull() {
		Usuario usuariotest=factory.createEntity();
		assertNotNull(usuariotest);
	}

	@Test
	public void CreateEntity_DefaultInvocation_UsuarioEntity() {
		Usuario usuariotest=factory.createEntity();
		assertTrue(usuariotest instanceof UsuarioEntity);
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_DefaultCedulaData()
	{
		Usuario usuariotest=factory.createEntity();
		assertTrue(ceduladefault.equals(usuariotest.getCedula()));
	}
	
	
	@Test
	public void CreateEntity_DefaultInvocation_DefaultPasswordData()
	{
		Usuario usuariotest=factory.createEntity();
		assertTrue(passworddefault.equals(usuariotest.getPassword()));
	}
	
	@Test
	public void CreateEntity_DefaultInvocation_DefaultNombreData()
	{
		Usuario usuariotest=factory.createEntity();
		assertTrue(nombredefault.equals(usuariotest.getNombre()));
	}

}
