package org.idisoft.restos.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.idisoft.restos.model.Usuario;

@Path(ConstantesREST.USUARIOS_SERVICE)
public interface UsuariosService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(ConstantesREST.USUARIOS_FUNCTION_AUTHENTICATE)
	public Response authenticateUsuario(
			@PathParam("login") final String login, 
			@FormParam("password") final String password);
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(ConstantesREST.USUARIOS_FUNCTION_REGISTER)
	public Response registerUsuario(final Usuario usuario);

}
