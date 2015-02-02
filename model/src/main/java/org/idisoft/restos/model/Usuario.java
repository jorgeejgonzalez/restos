package org.idisoft.restos.model;

public interface Usuario {	
	public String getCedula();
	public void setCedula(final String cedula);
	public String getEmail();
	public void setEmail(final String email);
	public String getPassword();
	public void setPassword(final String password);
	public TipoUsuario getTipo();
	public void setTipo(TipoUsuario tipo);
	public String getNombre();
	public void setNombre(final String nombre);
	public String getApellido();
	public void setApellido(final String apellido);
	public String getTelefono();
	public void setTelefono(final String telefono);
	public String getDireccion();
	public void setDireccion(final String direccion);
}
