package com.fleming.bancodelibros.modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name="admins")
public class Admin extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6686615372724772602L;

	@Column(name="n_colegiado")
	private String numeroColegiado;
	
	
	public Admin() {
		
	}
	
	public Admin(String dni,String nombre, String nColegiado, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.numeroColegiado = nColegiado;
	}

	
	
	public String getnColegiado() {
		return numeroColegiado;
	}

	public void setnColegiado(String nColegiado) {
		this.numeroColegiado = nColegiado;
	}

	@Override
	public String toString() {
		return this.getId()+":"+this.getNombre()+ " DNI: "+this.getDni()+" nº de colegiado: "+this.getnColegiado();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority("ADMIN"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getContrasenia();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getnUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
