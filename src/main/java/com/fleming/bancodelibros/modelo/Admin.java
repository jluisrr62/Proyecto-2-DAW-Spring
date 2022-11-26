package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends Usuario{
	
	@Column(name="n_colegiado")
	private String n_colegiado;
	
	@ManyToMany(mappedBy = "admins", fetch = FetchType.EAGER)
	private Set<Libro> libros;
	
	public Admin(String dni,String nombre, String n_colegiado, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.n_colegiado = n_colegiado;
		this.libros = new HashSet<Libro>();
	}

	public String getN_colegiado() {
		return n_colegiado;
	}

	public void setN_colegiado(String n_colegiado) {
		this.n_colegiado = n_colegiado;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	
	
}
