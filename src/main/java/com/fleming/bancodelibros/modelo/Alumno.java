package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alumnos")
public class Alumno extends Usuario{

	@OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
	private Set<Recogida> recogidas;

	public Alumno() {
	}
	
	public Alumno(String dni, String nombre, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.recogidas =  new HashSet<Recogida>();
	}

	@JsonIgnore
	public Set<Recogida> getRecogidas() {
		return recogidas;
	}

	@JsonIgnore
	public void setRecogidas(Set<Recogida> recogidas) {
		this.recogidas = recogidas;
	}


	@Override
	public String toString() {
		return  this.getId()+":"+this.getNombre()+ " DNI: "+this.getDni();
	}

	
	
}
