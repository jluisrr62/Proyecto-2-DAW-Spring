package com.fleming.bancodelibros.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "recogidas")
public class Recogida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="alumno_id")
	Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="libro_id")
	Libro libro;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	Date fecha;
	
	@Basic
	@Temporal(TemporalType.TIME)
	@Column(name="hora")
	Date hora;
	
	public Recogida(){
		this.fecha = new Date();
		this.hora = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
	 public Date parseFecha(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	    	 System.out.println("fecha incorrecta");
	         return null;
	     }
	  }
	
	 public Date parseHora(String date) {
	     try {
	         return new SimpleDateFormat("HH:mm").parse(date);
	     } catch (ParseException e) {
	    	 System.out.println("hora incorrecta");
	         return null;
	     }
	  }
	
	
}
