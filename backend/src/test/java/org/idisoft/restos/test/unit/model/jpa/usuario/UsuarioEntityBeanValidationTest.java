package org.idisoft.restos.test.unit.model.jpa.usuario;

import static org.junit.Assert.*;

import javax.validation.Validation;

import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.data.EntityValidator;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.junit.Before;
import org.junit.Test;

public class UsuarioEntityBeanValidationTest {
	
	private UsuarioEntity validUsuario;
	private UsuarioEntity invalidUsuario;
	
	private boolean isValid(UsuarioEntity usuario)
	{
		EntityValidator<UsuarioEntity> usuariobeanvalidator=new EntityValidator<UsuarioEntity>(Validation.buildDefaultValidatorFactory());
		usuariobeanvalidator.validate(usuario);
		return usuariobeanvalidator.isValid();
	}
	
	@Before
	public void SetUpUsuariosForTest()
	{
		validUsuario=TestEntitiesFactory.validUsuarioEntity();
		invalidUsuario=TestEntitiesFactory.validUsuarioEntity();
	}

	@Test
	public void BeanValidation_UsuarioValid_NoViolations() {
		assertTrue(isValid(validUsuario));
	}
	
	@Test
	public void BeanValidation_CedulaDoesNotHaveLetter_NotValid()
	{
		invalidUsuario.setCedula("0123456789");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_CedulaDoesNotBeginWithLetter_NotValid()
	{
		invalidUsuario.setCedula("123456789V");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_FirstLetterIsV_Valid()
	{
		validUsuario.setCedula("V987654321");
		assertTrue(isValid(validUsuario));
	}
	
	@Test
	public void BeanValidation_FirstLetterIsE_Valid()
	{
		validUsuario.setCedula("E987654321");
		assertTrue(isValid(validUsuario));
	}
	
	
	@Test
	public void BeanValidation_CedulaIsLessThanSize_NotValid()
	{
		invalidUsuario.setCedula("V123456");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_CedulaIsMoreThanSize_NotValid()
	{
		invalidUsuario.setCedula("V1234567890");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_EmailDoesNotHaveAt_NotValid()
	{
		invalidUsuario.setEmail("unittest.com");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_EmailDoesNotHaveDot_Valid()
	{
		validUsuario.setEmail("unit@testcom");
		assertTrue(isValid(validUsuario));
	}
	
	
	@Test
	public void BeanValidation_PasswordIsLessThanSize_NotValid()
	{
		invalidUsuario.setPassword("abcdefg");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_PasswordIsMoreThanSize_NotValid()
	{
		invalidUsuario.setPassword("abcdehijklmnopqrstuvwx");
		assertFalse(isValid(invalidUsuario));
	}
	
	
	@Test
	public void BeanValidation_TipoIsNull_NotValid()
	{
		invalidUsuario.setTipo(null);
		assertFalse(isValid(invalidUsuario));
	}
	
	
	@Test
	public void BeanValidation_NombreIsLessThanMinSize_NotValid()
	{
		invalidUsuario.setNombre("ab");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_NombreIsMoreThanMaxSize_NotValid()
	{
		invalidUsuario.setNombre("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_NombreHasNumbers_NotValid()
	{
		invalidUsuario.setNombre("unit1");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_NombreHasEmptySpaces_Valid()
	{
		validUsuario.setNombre("unit test");
		assertTrue(isValid(validUsuario));
	}
	
	@Test
	public void BeanValidation_ApellidoIsLessThanMinSize_NotValid()
	{
		invalidUsuario.setApellido("ab");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_ApellidoIsMoreThanMaxSize_NotValid()
	{
		invalidUsuario.setNombre("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_ApellidoHasNumbers_NotValid()
	{
		invalidUsuario.setApellido("unit1");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_ApellidoHasEmptySpaces_Valid()
	{
		validUsuario.setNombre("unit test");
		assertTrue(isValid(validUsuario));
	}
	
	
	@Test
	public void BeanValidation_DireccionIsMoreThanMaxSize_NotValid()
	{
		invalidUsuario.setDireccion("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		assertFalse(isValid(invalidUsuario));
	}
	
	
	@Test
	public void BeanValidation_TelefonoIsLessThanMinSize_NotValid()
	{
		invalidUsuario.setTelefono("1234567890");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_TelefonoIsMoreThanMaxSize_NotValid()
	{
		invalidUsuario.setTelefono("123456789012");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_TelefonoHasLetters_NotValid()
	{
		invalidUsuario.setTelefono("1234567890A");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_TelefonoHasDash_NotValid()
	{
		invalidUsuario.setTelefono("1-234567890");
		assertFalse(isValid(invalidUsuario));
	}
	
	@Test
	public void BeanValidation_EstatusRegistroIsNull_NotValid()
	{
		invalidUsuario.setEstatusRegistro(null);
		assertFalse(isValid(invalidUsuario));
	}

}
