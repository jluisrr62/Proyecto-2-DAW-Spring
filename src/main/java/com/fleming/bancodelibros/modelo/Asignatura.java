package com.fleming.bancodelibros.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignaturas")
public class Asignatura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 531990370836144078L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="curso")
	private String curso;
	
	@OneToMany(mappedBy="asignatura")
	private Set<Libro> libros;
	
	public Asignatura() {
		
	}
	
	public Asignatura(String nombre,String curso) {
		this.nombre = nombre;
		this.curso = curso;
		this.libros =  new HashSet<Libro>();
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
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
}
