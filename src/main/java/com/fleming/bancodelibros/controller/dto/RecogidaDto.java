package com.fleming.bancodelibros.controller.dto;

import java.time.LocalDateTime;

public class RecogidaDto {
	
	private String dni;
	
	private String isbn;
	
	private LocalDateTime fecha;

	public RecogidaDto() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
