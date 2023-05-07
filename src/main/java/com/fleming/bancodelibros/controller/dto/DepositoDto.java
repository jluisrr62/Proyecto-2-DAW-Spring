package com.fleming.bancodelibros.controller.dto;

import java.time.LocalDateTime;

public class DepositoDto {
	
	private String nColegiado;
	
	private String isbn;
	
	private LocalDateTime fecha;

	public DepositoDto() {
		
	}

	public String getnColegiado() {
		return nColegiado;
	}

	public void setnColegiado(String nColegiado) {
		this.nColegiado = nColegiado;
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
