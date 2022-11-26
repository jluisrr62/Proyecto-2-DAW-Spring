package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno extends Usuario{

	@OneToMany(mappedBy="alumno")
	private Set<Recogida> recogidas;

	
	public Alumno(String dni, String nombre, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.recogidas =  new HashSet<Recogida>();
	}


	public Set<Recogida> getRecogidas() {
		return recogidas;
	}


	public void setRecogidas(Set<Recogida> recogidas) {
		this.recogidas = recogidas;
	}

	
	
}
