package com.fleming.bancodelibros.modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name="alumnos")
public class Alumno extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1300591480605657050L;

//	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "alumno")
//	private List<Recogida> recogidas;

	
	public Alumno() {
	}
	
	public Alumno(String dni, String nombre, String nUsuario, String contrasenia) {
		super(dni, nombre, nUsuario, contrasenia);
		// TODO Auto-generated constructor stub
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
