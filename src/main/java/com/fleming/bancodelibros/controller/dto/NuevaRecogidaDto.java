package com.fleming.bancodelibros.controller.dto;

public class NuevaRecogidaDto {
	private String nombreUsuario;
	private Long idLibro;
	
	
	public NuevaRecogidaDto() {
		
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}
}
