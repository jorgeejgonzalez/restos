package org.idisoft.restos.administracionusuarios.business;

import org.idisoft.restos.model.TipoUsuario;
import org.idisoft.restos.model.Usuario;

public class UsuarioDTO implements Usuario {

	private String cedula;	
	private String password;
	private String email;
	private TipoUsuario tipo;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	
	@Override
	public String getCedula() {
		return cedula;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setCedula(final String cedula) {
		this.cedula=cedula;
	}

	@Override
	public void setPassword(final String password) {
		this.password=password;
	}
	
	@Override
	public String getNombre()
	{
		return nombre;
	}
	
	@Override
	public void setNombre(final String nombre)
	{
		this.nombre=nombre;
	}

	@Override
	public String getApellido() {
		return apellido;
	}

	@Override
	public void setApellido(final String apellido) {
		this.apellido=apellido;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(final String email) {
		this.email=email;
	}

	@Override
	public TipoUsuario getTipo() {		
		return tipo;
	}

	@Override
	public void setTipo(final TipoUsuario tipo) {
		this.tipo=tipo;
	}

	@Override
	public String getDireccion() {
		return direccion;
	}

	@Override
	public void setDireccion(final String direccion) {
		this.direccion=direccion;
	}

	@Override
	public String getTelefono() {
		return telefono;
	}

	@Override
	public void setTelefono(final String telefono) {
		this.telefono=telefono;
	}

}
