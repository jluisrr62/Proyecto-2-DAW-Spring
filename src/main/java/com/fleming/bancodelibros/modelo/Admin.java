package com.fleming.bancodelibros.modelo;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6686615372724772602L;

	@Column(name="n_colegiado")
	private String nColegiado;
	
	@OneToMany(mappedBy="admin", fetch = FetchType.LAZY)
	private Set<Deposito> depositos;
	
	public Admin() {
		
	}
	
	public Admin(String dni,String nombre, String nColegiado, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.nColegiado = nColegiado;
		this.depositos = new HashSet<Deposito>();
	}

	
	
	public String getnColegiado() {
		return nColegiado;
	}

	public void setnColegiado(String nColegiado) {
		this.nColegiado = nColegiado;
	}

	public Set<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(Set<Deposito> depositos) {
		this.depositos = depositos;
	}

	@Override
	public String toString() {
		return this.getId()+":"+this.getNombre()+ " DNI: "+this.getDni()+" nº de colegiado: "+this.getnColegiado();
	}
	
	
	
}
