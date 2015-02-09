package org.idisoft.restos.test.unit.administracionusuarios.business.bean;

import static org.mockito.Mockito.when;

import javax.validation.ValidationException;

import org.idisoft.restos.administracionusuarios.business.AdministradorUsuariosBean;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTOFactory;
import org.idisoft.restos.administracionusuarios.business.repository.UsuariosRepository;
import org.idisoft.restos.test.util.TestEntitiesFactory;
import org.mockito.Mock;

public abstract class AbstractAdministradorUsuariosBeanTest {
	
	protected AdministradorUsuariosBean administradorUsuarios;
	
	@Mock
	protected UsuariosRepository usuariosRepositoryMock;	
	@Mock
	protected UsuarioDTOFactory usuarioDTOsFactoryMock;
	
	protected void instanciacion()
	{
		administradorUsuarios=new AdministradorUsuariosBean(usuarioDTOsFactoryMock,usuariosRepositoryMock);
	}
	
	protected void mockitoRules()
	{
		when(usuariosRepositoryMock.add(TestEntitiesFactory.validUsuario())).thenReturn(TestEntitiesFactory.validUsuarioEntity());
		when(usuariosRepositoryMock.add(TestEntitiesFactory.invalidUsuario())).thenThrow(new ValidationException());
		when(usuariosRepositoryMock.findByEmail(TestEntitiesFactory.VALID_EMAIL)).thenReturn(TestEntitiesFactory.validUsuario());
		when(usuarioDTOsFactoryMock.copyEntity(TestEntitiesFactory.validUsuario())).thenReturn(TestEntitiesFactory.validUsuarioDTO());
	}


}
