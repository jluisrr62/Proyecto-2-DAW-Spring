package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="admins")
public class Admin extends Usuario{
	
	@Column(name="n_colegiado")
	private String nColegiado;
	
	@ManyToMany(mappedBy = "admins", fetch = FetchType.LAZY)
	private Set<Libro> libros;
	
	public Admin() {
		
	}
	
	public Admin(String dni,String nombre, String nColegiado, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.nColegiado = nColegiado;
		this.libros = new HashSet<Libro>();
	}

	
	
	public String getnColegiado() {
		return nColegiado;
	}

	public void setnColegiado(String nColegiado) {
		this.nColegiado = nColegiado;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return this.getId()+":"+this.getNombre()+ " DNI: "+this.getDni()+" nº de colegiado: "+this.getnColegiado();
	}
	
	
	
}
