package com.fleming.bancodelibros.modelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alumnos")
public class Alumno extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1300591480605657050L;
	@OneToMany(mappedBy="alumno", fetch = FetchType.LAZY)
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("USER"));
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
