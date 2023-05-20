package com.fleming.bancodelibros.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AlumnoDto {

	private Long id;
	
	private String dni;
	
	private String nombre;
	
	private String nUsuario;
	
	private String contrasenia;
	
	private List<LocalDateTime> recogidas;

	public AlumnoDto() {
		
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

	public List<LocalDateTime> getRecogidas() {
		return recogidas;
	}

	public void setRecogidas(List<LocalDateTime> recogidas) {
		this.recogidas = recogidas;
	}
}
