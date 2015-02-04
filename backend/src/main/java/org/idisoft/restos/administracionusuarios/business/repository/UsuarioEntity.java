package org.idisoft.restos.administracionusuarios.business.repository;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.idisoft.restos.model.TipoUsuario;
import org.idisoft.restos.model.Usuario;
import org.idisoft.restos.data.EstatusRegistro;
import org.idisoft.restos.data.Registro;

@SuppressWarnings("serial")
@Entity
@Table(
		name = UsuarioEntityConstantesORM.USUARIO_TABLE_NAME,
		uniqueConstraints=
		{
				@UniqueConstraint(columnNames=UsuarioEntityConstantesORM.USUARIO_EMAIL_ATTRIBUTE_NAME)
		}
)
public class UsuarioEntity implements Usuario, Registro, Serializable {
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_CEDULA_COLUMN_NAME)
	@Id
	@NotNull
	@Pattern(regexp=UsuarioEntityConstantesValidation.USUARIO_CEDULA_REGEXP)
	@Size(min=UsuarioEntityConstantesValidation.USUARIO_CEDULA_MIN_SIZE,
			max=UsuarioEntityConstantesValidation.USUARIO_CEDULA_MAX_SIZE)
	private String cedula;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_PASSWORD_COLUMN_NAME)
	@NotNull
	@Size(min=UsuarioEntityConstantesValidation.USUARIO_PASSWORD_MIN_SIZE,
			max=UsuarioEntityConstantesValidation.USUARIO_PASSWORD_MAX_SIZE)
	private String password;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_EMAIL_COLUMN_NAME)
	@NotNull
	@Email
	private String email;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_TIPO_COLUMN_NAME)
	@NotNull
	private TipoUsuario tipo;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_NOMBRE_COLUMN_NAME)
	@NotNull
	@Pattern(regexp=UsuarioEntityConstantesValidation.USUARIO_NOMBRE_REGEXP)
	@Size(min=UsuarioEntityConstantesValidation.USUARIO_NOMBRE_MIN_SIZE,
			max=UsuarioEntityConstantesValidation.USUARIO_NOMBRE_MAX_SIZE)
	private String nombre;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_APELLIDO_COLUMN_NAME)
	@NotNull
	@Pattern(regexp=UsuarioEntityConstantesValidation.USUARIO_APELLIDO_REGEXP)
	@Size(min=UsuarioEntityConstantesValidation.USUARIO_APELLIDO_MIN_SIZE,
			max=UsuarioEntityConstantesValidation.USUARIO_APELLIDO_MAX_SIZE)
	private String apellido;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_DIRECCION_COLUMN_NAME)
	@NotNull
	@Size(max=UsuarioEntityConstantesValidation.USUARIO_DIRECCION_MAX_SIZE)
	private String direccion;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_TELEFONO_COLUMN_NAME)
	@NotNull
	@Pattern(regexp=UsuarioEntityConstantesValidation.USUARIO_TELEFONO_REGEXP)
	@Size(min=UsuarioEntityConstantesValidation.USUARIO_TELEFONO_MIN_SIZE, 
			max=UsuarioEntityConstantesValidation.USUARIO_TELEFONO_MAX_SIZE)
	private String telefono;
	
	@Column(name=UsuarioEntityConstantesORM.USUARIO_ESTATUSREGISTRO_COLUMN_NAME)
	@NotNull
	private EstatusRegistro estatusregistro;

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

	@Override
	public EstatusRegistro getEstatusRegistro() {
		return estatusregistro;
	}

	@Override
	public void setEstatusRegistro(final EstatusRegistro estatusregistro) {
		this.estatusregistro=estatusregistro;
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean check=false;
		if(o instanceof UsuarioEntity)
		{
			UsuarioEntity usuariocheck=(UsuarioEntity) o;
			check=cedula.equals(usuariocheck.getCedula())					
					&& password.equals(usuariocheck.getPassword())
					&& email.equals(usuariocheck.getEmail())
					&& nombre.equals(usuariocheck.getNombre())
					&& apellido.equals(usuariocheck.getApellido())
					&& direccion.equals(usuariocheck.getDireccion())
					&& telefono.equals(usuariocheck.getTelefono());
		}
		return check;
	}
	
	@Override
	public int hashCode()
	{
		int hash=Objects.hash(cedula,
				password,email,
				nombre,apellido,
				direccion,telefono);
		return hash;
	}
}
