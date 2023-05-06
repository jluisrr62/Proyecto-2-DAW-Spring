package com.fleming.bancodelibros.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class RecogidaId implements Serializable{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3597696445523234482L;

	@Column(name = "fecha_hora")
	private LocalDateTime Fecha;
	
	@Column(name = "alumno_id")
	private Long alumnoId;
	
	@Column(name = "libro_id")
	private Long libroId;

	public LocalDateTime getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		Fecha = fecha;
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public Long getLibroId() {
		return libroId;
	}

	public void setLibroId(Long libroId) {
		this.libroId = libroId;
	}
	
	
	
	
}
