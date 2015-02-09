package org.idisoft.restos.test.unit.data.repository.usuarios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.NoResultException;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityConstantesORM;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.data.DataAccessObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosRepositoryFindByLoginTest extends AbstractUsuariosRepositoryTest {
	
	@Test
	public void FindByLogin_LoginIsInDatabase_ReturnsUsuario() throws Exception
	{
		instantiateEntities();
		
		DataAccessObject<UsuarioEntity>.Filter filter=usuariojpadaostub.new Filter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailInRepository);
		
		when(usuariojpadaostub.createFilter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailInRepository)).thenReturn(filter);
		when(usuariojpadaostub.findSingle(filter)).thenReturn(validUsuarioEntity);
		
		instantiateRepositoryWithMocks();
		
		Usuario usuariocheck= repository.findByEmail(emailInRepository);
		assertNotNull(usuariocheck);
	}
	
	@Test(expected=NoResultException.class)
	public void FindByLogin_LoginIsNotInDatabase_ThrowsNoResultException() throws Exception
	{
		instantiateEntities();
		
		DataAccessObject<UsuarioEntity>.Filter filter=usuariojpadaostub.new Filter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailNotInRepository);
		
		when(usuariojpadaostub.createFilter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailNotInRepository)).thenReturn(filter);
		when(usuariojpadaostub.findSingle(filter)).thenThrow(new NoResultException());
		
		instantiateRepositoryWithMocks();
		
		@SuppressWarnings("unused")
		Usuario usuariocheck= repository.findByEmail(emailNotInRepository);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void FindByLogin_LoginIsNull_ThrowsIllegalArgumenException()
	{
		instantiateRepositoryWithMocks();
		Usuario usuariocheck= repository.findByEmail(loginNull);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void FindByLogin_LoginIsEmpty_ThrowsIllegalArgumenException()
	{
		instantiateRepositoryWithMocks();
		Usuario usuariocheck= repository.findByEmail(loginEmpty);
	}
	
	@Test(expected=NoResultException.class)
	public void FindByLogin_UsuarioEstatusRegistroIsDeleted_ThrowsNoResultException() throws Exception
	{
		instantiateEntities();
		
		DataAccessObject<UsuarioEntity>.Filter filter=usuariojpadaostub.new Filter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailNotInRepository);
		
		when(usuariojpadaostub.createFilter(UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME, emailNotInRepository)).thenReturn(filter);
		when(usuariojpadaostub.findSingle(filter)).thenThrow(new NoResultException());
		
		instantiateRepositoryWithMocks();
		
		@SuppressWarnings("unused")
		Usuario usuariocheck= repository.findByEmail(emailNotInRepository);
	}

}
