package com.fleming.bancodelibros.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AdminDto {
	
	private Long id;
	
	private String dni;
	
	private String nombre;
	
	private String nColegiado;
	
	private String nUsuario;
	
	private String contrasenia;
	
	private List<LocalDateTime> depositos;

	public AdminDto() {
		
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

	public String getnColegiado() {
		return nColegiado;
	}

	public void setnColegiado(String nColegiado) {
		this.nColegiado = nColegiado;
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

	public List<LocalDateTime> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<LocalDateTime> depositos) {
		this.depositos = depositos;
	}
}
