package org.idisoft.restos.rest;

import org.idisoft.restos.administracionusuarios.business.repository.UsuarioEntityConstantesValidation;

public class ConstantesREST {
	
	public static final String SERVICES_PATH="/services";
	
	public static final String USUARIOS_SERVICE="/usuarios";
	public static final String USUARIOS_FUNCTION_AUTHENTICATE="/{login:"+UsuarioEntityConstantesValidation.USUARIO_LOGIN_REGEXP+"}";
	public static final String USUARIOS_FUNCTION_REGISTER="/";

}
