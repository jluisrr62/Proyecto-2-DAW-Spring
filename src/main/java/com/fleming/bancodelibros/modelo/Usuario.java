package com.fleming.bancodelibros.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3112532531082254537L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id")
	private Long id;
	
	@Column(name="dni", length=64)
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="n_usuario")
	private String nUsuario;
	
	@Column(name="contrasenia")
	private String contrasenia;

	public Usuario(String dni, String n, String nUsuario, String password) {
		this.dni = dni;
		this.nombre = n;
		this.nUsuario = nUsuario;
		this.contrasenia = password;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnUsuario() {
		return nUsuario;
	}

	public void setnUsuario(String nUsuario) {
		this.nUsuario = nUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
}
