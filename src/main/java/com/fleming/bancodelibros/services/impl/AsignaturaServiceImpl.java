package com.fleming.bancodelibros.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.repos.AsignaturaRepository;
import com.fleming.bancodelibros.services.AsignaturaService;

public class AsignaturaServiceImpl implements AsignaturaService{

	@Autowired
	private AsignaturaRepository asignaturaRepo;
	
	@Override
	public List<String> getNombresByLibros(Set<Libro> libros) {
		
		return asignaturaRepo.encontrarNombresByLibros(libros);
	}

	@Override
	public Asignatura getAsignaturaByNombre(String asignatura) {
		
		return asignaturaRepo.findByNombre(asignatura);
	}

}
