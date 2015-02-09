package org.idisoft.restos.test.unit.data.repository.usuarios;

import static org.mockito.Mockito.when;

import javax.validation.Validation;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityFactory;
import org.idisoft.restos.administracionusuarios.business.repository.UsuariosRepository;
import org.idisoft.restos.data.EntityValidator;
import org.idisoft.restos.data.DataAccessObject;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.mockito.Mock;

public abstract class AbstractUsuariosRepositoryTest 
{
	protected UsuariosRepository repository;
	
	@Mock
	protected UsuarioEntityFactory usuariojpafactorystub;
	@Mock
	protected DataAccessObject<UsuarioEntity> usuariojpadaostub;
	
	protected EntityValidator<UsuarioEntity> beanvalidatorusuariojpa;
	
	protected Usuario invalidUsuario;
	protected Usuario validUsuario;
	protected UsuarioEntity validUsuarioEntity;
	protected UsuarioEntity invalidUsuarioEntity;
	protected UsuarioDTO validUsuarioTransfer;
	
	protected String cedulaInRepository="V123456789";
	protected String cedulaNotInRepository="V987654321";
	protected String emailInRepository="unit@test.com";
	protected String emailNotInRepository="notest";
	protected String loginEmpty="";
	protected String loginNull=null;
	
	protected void instantiateEntities()
	{
		invalidUsuario=TestEntitiesFactory.invalidUsuario();
		invalidUsuarioEntity=TestEntitiesFactory.invalidUsuarioEntity();		
		validUsuario=TestEntitiesFactory.validUsuario();
		validUsuarioEntity=TestEntitiesFactory.validUsuarioEntity();
		validUsuarioTransfer=TestEntitiesFactory.validUsuarioDTO();
	}
	
	protected void setUpMockitoRules()
	{
		when(usuariojpafactorystub.copyEntity(validUsuario)).thenReturn(validUsuarioEntity);
	}
	
	protected void instantiateRepositoryWithMocks()
	{	
		beanvalidatorusuariojpa=new EntityValidator<UsuarioEntity>(Validation.buildDefaultValidatorFactory());
		setUpMockitoRules();
		repository=new UsuariosRepository(
				usuariojpadaostub,
				beanvalidatorusuariojpa,
				usuariojpafactorystub);
	}
	
}
