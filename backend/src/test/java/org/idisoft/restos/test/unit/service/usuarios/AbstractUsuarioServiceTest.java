package org.idisoft.restos.test.unit.service.usuarios;

import org.idisoft.restos.administracionusuarios.AdministradorUsuarios;
import org.idisoft.restos.rest.UsuariosService;
import org.idisoft.restos.rest.UsuariosServiceRest;
import org.idisoft.restos.test.unit.service.AbstractRestServiceTest;
import org.mockito.Mock;

public class AbstractUsuarioServiceTest extends AbstractRestServiceTest 
{
	
	protected UsuariosService usuarioService;
	
	@Mock
	protected AdministradorUsuarios administradorUsuariosMock;
	
	protected void instanciacion()
	{
		usuarioService=new UsuariosServiceRest(administradorUsuariosMock);
	}
	
}
