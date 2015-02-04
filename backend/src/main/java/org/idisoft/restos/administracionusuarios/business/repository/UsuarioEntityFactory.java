package org.idisoft.restos.administracionusuarios.business.repository;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;

import org.idisoft.restos.model.TipoUsuario;
import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.data.EstatusRegistro;
import org.idisoft.restos.factory.ModelFactory;

@RequestScoped
public class UsuarioEntityFactory implements ModelFactory<UsuarioEntity> {

	private UsuarioEntity defaultUsuarioJPA()
	{
		UsuarioEntity retorno=new UsuarioEntity();
		retorno.setCedula("V00000000");		
		retorno.setPassword("");
		retorno.setEmail("");
		retorno.setTipo(TipoUsuario.FINAL);
		retorno.setNombre("");
		retorno.setApellido("");
		retorno.setDireccion("");
		retorno.setTelefono("");
		retorno.setEstatusRegistro(EstatusRegistro.ACTIVO);
		return retorno;
	}
	
	@Override
	public UsuarioEntity createEntity() {
		UsuarioEntity retorno=defaultUsuarioJPA();
		return retorno;
	}
	
	public UsuarioEntity createEntity(
			String cedula,
			String password,
			String email,
			String nombre,
			String apellido,
			String direccion,
			String telefono)
	{
		UsuarioEntity retorno=defaultUsuarioJPA();
		retorno.setCedula(cedula);		
		retorno.setPassword(password);
		retorno.setEmail(email);
		retorno.setNombre(nombre);
		retorno.setApellido(apellido);
		retorno.setDireccion(direccion);
		retorno.setTelefono(telefono);
		return retorno;
	}
	
	public UsuarioEntity copyEntity(Usuario original) {
		UsuarioEntity copia=defaultUsuarioJPA();
		copia.setCedula(original.getCedula());		
		copia.setPassword(original.getPassword());
		copia.setEmail(original.getEmail());
		copia.setTipo(original.getTipo());
		copia.setNombre(original.getNombre());
		copia.setApellido(original.getApellido());
		copia.setDireccion(original.getDireccion());
		copia.setTelefono(original.getTelefono());
		return copia;
	}

	@Override
	public UsuarioEntity copyEntity(UsuarioEntity original) {
		return this.copyEntity((Usuario)original);
	}

	@Override
	public List<UsuarioEntity> createList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UsuarioEntity> createSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
