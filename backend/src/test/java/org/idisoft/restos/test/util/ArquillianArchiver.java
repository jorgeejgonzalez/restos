package org.idisoft.restos.test.util;

import org.idisoft.restos.administracionusuarios.AdministradorUsuarios;
import org.idisoft.restos.model.TipoUsuario;
import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.AdministradorUsuariosBean;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTO;
import org.idisoft.restos.administracionusuarios.business.UsuarioDTOFactory;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntity;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityConstantesORM;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityConstantesValidation;
import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityFactory;
import org.idisoft.restos.administracionusuarios.business.repository.UsuariosRepository;
import org.idisoft.restos.data.CDIPersistenceResources;
import org.idisoft.restos.data.DataAccessObject;
import org.idisoft.restos.data.EntityValidator;
import org.idisoft.restos.data.EstatusRegistro;
import org.idisoft.restos.data.Registro;
import org.idisoft.restos.data.Repository;
import org.idisoft.restos.factory.DTOFactory;
import org.idisoft.restos.factory.EntityFactory;
import org.idisoft.restos.factory.ModelFactory;
import org.idisoft.restos.rest.AbstractRestService;
import org.idisoft.restos.rest.ConstantesREST;
import org.idisoft.restos.rest.JaxRsActivator;
import org.idisoft.restos.rest.UsuariosService;
import org.idisoft.restos.rest.UsuariosServiceRest;
import org.idisoft.restos.test.unit.service.AbstractRestServiceTest;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class ArquillianArchiver {
	
	public static WebArchive getIntegrationWarFile()
	{
		WebArchive war = getStandardWarFile();		
		war.addAsResource("META-INF/persistence.xml");
		war.addAsResource("META-INF/test-persistence-integration.xml");		
		war.addAsWebInfResource("test-ds-integration.xml");
		System.out.println(war.toString(true));
		return war;
	}
	
	public static WebArchive getStandardWarFile()
	{
		WebArchive war=ShrinkWrap.create(WebArchive.class,"test.war");
		
		war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		
		war.addClasses(
				CDIPersistenceResources.class,
				DataAccessObject.class,
				EntityValidator.class,
				EstatusRegistro.class,
				Registro.class,
				Repository.class
				);
		
		war.addClasses(
				AdministradorUsuarios.class,
				TipoUsuario.class,
				Usuario.class
				);
		
		war.addClasses(
				AdministradorUsuariosBean.class,
				UsuarioDTO.class,
				UsuarioDTOFactory.class
				);
		
		war.addClasses(
				UsuarioEntity.class,
				UsuarioEntityConstantesORM.class,
				UsuarioEntityConstantesValidation.class,
				UsuarioEntityFactory.class,
				UsuariosRepository.class
				);
		
		war.addClasses(
				DTOFactory.class,
				EntityFactory.class,
				ModelFactory.class
				);
		
		war.addClasses(
				AbstractRestService.class,
				ConstantesREST.class,
				JaxRsActivator.class,
				UsuariosService.class,
				UsuariosServiceRest.class
				);
		
		war.addClasses(AbstractRestServiceTest.class);
		
		war.addClasses(TestEntitiesFactory.class);
				
		return war;
	}
	

}
