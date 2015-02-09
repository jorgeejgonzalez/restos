package org.idisoft.restos.test.acceptance;

import org.idisoft.restos.test.util.ArquillianArchiver;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.arquillian.CukeSpace;
import cucumber.runtime.arquillian.api.Features;

@RunWith(CukeSpace.class)
@Features("src/test/resources/org/idisoft/restos/test/acceptance/realizarlogin.feature")
public class RealizarLogin {
	
	@Deployment
	public static Archive<?> deploymentArchive()
	{
		return ArquillianArchiver.getStandardWarFile();
	}
	
	@Given("^que el Usuario acceptance@test\\.com este registrado en la base de datos$")
	public void que_el_Usuario_acceptance_test_com_este_registrado_en_la_base_de_datos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^su password es acceptance$")
	public void su_password_es_acceptance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^se invoque el servicio de Autenticacion$")
	public void se_invoque_el_servicio_de_Autenticacion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^el HTTP Response Status debe ser (\\d+)$")
	public void el_HTTP_Response_Status_debe_ser(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
