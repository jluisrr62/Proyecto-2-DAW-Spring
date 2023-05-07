package com.fleming.bancodelibros.controller.dto;

import java.util.List;

public class AsignaturaDto {
	
	private Long id;
	
	private String nombre;
	
	private String curso;
	
	private List<String> nombresLibros;

	public AsignaturaDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<String> getNombresLibros() {
		return nombresLibros;
	}

	public void setNombresLibros(List<String> nombresLibros) {
		this.nombresLibros = nombresLibros;
	}
}
