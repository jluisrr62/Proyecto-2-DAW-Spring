package com.fleming.bancodelibros.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Depositos")
public class Deposito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3992505824990987472L;

	@EmbeddedId
	private DepositoId id;
	
	@ManyToOne
	@JoinColumn(name="admin_id", updatable = false, insertable = false)
	Admin admin;
	
	@ManyToOne
	@JoinColumn(name="libro_id", updatable = false, insertable = false)
	Libro libro;
	
	public Deposito() {

	}

	public Deposito(DepositoId id, Admin admin, Libro libro) {
		super();
		this.id = id;
		this.admin = admin;
		this.libro = libro;
	}

	public DepositoId getId() {
		return id;
	}

	public void setId(DepositoId id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
}
