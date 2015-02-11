package org.idisoft.restos.test.integration.administracionusuarios.data;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.administracionusuarios.business.repository.UsuariosRepository;
import org.idisoft.restos.test.util.ArquillianArchiver;
import org.idisoft.restos.test.util.ConstantesDataTestFiles;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@UsingDataSet(ConstantesDataTestFiles.DATAFILE_USUARIOS)
@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
public class UsuariosRepositoryFindByEmailIntegrationTest {
	
	@Inject
	private UsuariosRepository repository;
	
	private String emailEmpty="";
	private String emailNull=null;
	private String emailInDataset="test@integration.com";
	private String emailNotInDataset="test";
	
	@Deployment
	public static Archive<?> createTestArchive()
	{
		WebArchive war=ArquillianArchiver.getIntegrationWarFile();
		return  war;
	}

	@Test
	
	public void FindByLogin_LoginIsInDatabase_ReturnsUsuario() throws Exception
	{
		Usuario usuariocheck= repository.findByEmail(emailInDataset);
		assertNotNull(usuariocheck);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=NoResultException.class)
	public void FindByLogin_LoginIsNotInDatabase_NoResultException()
	{
		Usuario usuariocheck= repository.findByEmail(emailNotInDataset);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void FindByLogin_LoginIsNull_IllegalArgumentException()
	{
		Usuario usuariocheck= repository.findByEmail(emailNull);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void FindByLogin_LoginIsEmpty_IllegalArgumentException()
	{
		Usuario usuariocheck= repository.findByEmail(emailEmpty);
	}

}
