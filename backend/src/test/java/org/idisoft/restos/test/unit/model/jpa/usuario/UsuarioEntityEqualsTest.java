package org.idisoft.restos.test.unit.model.jpa.usuario;

import static org.junit.Assert.*;

import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;

public class UsuarioEntityEqualsTest {
	
	private UsuarioEntity validusuario;
	private UsuarioEntity compareusuario;
	
	@Before
	public void setUpUsuarios()
	{
		validusuario= TestEntitiesFactory.validUsuarioEntity();
		compareusuario= TestEntitiesFactory.validUsuarioEntity();
	}
	
	@Test
	public void Equals_SameValues_Equals()
	{
		assertEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_SameValues_SameHashCode()
	{
		assertEquals(validusuario.hashCode(), compareusuario.hashCode());
	}
	
	@Test
	public void Equals_DifferentValues_DifferentHashCode()
	{
		compareusuario.setCedula("");
		assertNotEquals(validusuario.hashCode(), compareusuario.hashCode());
	}
	
	@Test
	public void Equals_DifferentCedula_NotEqual()
	{
		String testcedula="V00000000";
		compareusuario.setCedula(testcedula);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentPassword_NotEqual()
	{
		String testpassword="abcdef";
		compareusuario.setPassword(testpassword);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentEmail_NotEqual()
	{
		String testemail="abc@def";
		compareusuario.setEmail(testemail);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentNombre_NotEqual()
	{
		String testnombre="abcdef";
		compareusuario.setNombre(testnombre);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentApellido_NotEqual()
	{
		String testapellido="abcdef";
		compareusuario.setApellido(testapellido);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentDireccion_NotEqual()
	{
		String testdireccion="abcdef";
		compareusuario.setDireccion(testdireccion);
		assertNotEquals(validusuario, compareusuario);
	}
	
	@Test
	public void Equals_DifferentTelefono_NotEqual()
	{
		String testtelefono="98765432109";
		compareusuario.setTelefono(testtelefono);
		assertNotEquals(validusuario, compareusuario);
	}

}