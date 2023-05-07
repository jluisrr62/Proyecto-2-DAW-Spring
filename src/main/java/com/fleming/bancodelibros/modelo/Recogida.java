package com.fleming.bancodelibros.modelo;



import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recogidas")
public class Recogida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7486859356006199879L;

	@EmbeddedId
	private RecogidaId id;
	
	@ManyToOne
	@JoinColumn(name="alumno_id", updatable = false, insertable = false)
	Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="libro_id", updatable = false, insertable = false)
	Libro libro;
	

	
	public RecogidaId getId() {
		return id;
	}

	public void setId(RecogidaId id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
