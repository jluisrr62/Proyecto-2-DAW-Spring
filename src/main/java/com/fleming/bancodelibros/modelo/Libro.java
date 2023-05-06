package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ISBN")
	private String ISBN;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "admins_libros",
			joinColumns = {@JoinColumn(name= "id_libro")},
			inverseJoinColumns = {@JoinColumn(name="id_admin")}
		)
	private Set<Admin> admins;
	
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
		this.admins = new HashSet<Admin>();
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

	public Set<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}

	
	
	
}
