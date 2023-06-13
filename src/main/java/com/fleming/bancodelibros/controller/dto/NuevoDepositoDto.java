package com.fleming.bancodelibros.controller.dto;

public class NuevoDepositoDto {
	private String nombreUsuario;
	private Long idLibro;
	
	public NuevoDepositoDto() {
		
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
