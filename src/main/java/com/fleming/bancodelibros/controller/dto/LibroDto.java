package com.fleming.bancodelibros.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

public class LibroDto {
	
	private Long id;
	
	private String isbn;
	
	private String nombre;
	
	private List<LocalDateTime> fechasDepositos;
	
	private List<LocalDateTime> fechasRecogidas;
	
	private String asignatura;

	public LibroDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LocalDateTime> getFechasDepositos() {
		return fechasDepositos;
	}

	public void setFechasDepositos(List<LocalDateTime> fechasDepositos) {
		this.fechasDepositos = fechasDepositos;
	}

	public List<LocalDateTime> getFechasRecogidas() {
		return fechasRecogidas;
	}

	public void setFechasRecogidas(List<LocalDateTime> fechasRecogidas) {
		this.fechasRecogidas = fechasRecogidas;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
}
