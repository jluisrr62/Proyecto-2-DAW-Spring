package com.fleming.bancodelibros.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DepositoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1966660972842828669L;

	@Column(name = "fecha_hora")
	private LocalDateTime Fecha;
	
	@Column(name = "admin_id")
	private Long adminId;
	
	@Column(name = "libro_id")
	private Long libroId;

	public LocalDateTime getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		Fecha = fecha;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getLibroId() {
		return libroId;
	}

	public void setLibroId(Long libroId) {
		this.libroId = libroId;
	}
	
}
