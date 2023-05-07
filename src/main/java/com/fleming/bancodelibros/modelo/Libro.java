package com.fleming.bancodelibros.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1427189113561464543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ISBN")
	private String ISBN;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy="libro")
	Set<Deposito> depositos;
	
	@OneToMany(mappedBy="libro")
	Set<Recogida> recogidas;
	
	@ManyToOne
	@JoinColumn(name="asignatura_id")
	Asignatura asignatura;
	
	public Libro() {
		
	}
	
	public Libro(String ISBN, String nombre){
		this.ISBN = ISBN;
		this.nombre = nombre;
		this.recogidas =  new HashSet<Recogida>();
		this.depositos = new HashSet<Deposito>();
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Recogida> getRecogidas() {
		return recogidas;
	}

	public void setRecogidas(Set<Recogida> recogidas) {
		this.recogidas = recogidas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(Set<Deposito> depositos) {
		this.depositos = depositos;
	}
}
