package com.fleming.bancodelibros.services;

import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;

public interface AsignaturaService {

	List<String> getNombresByLibros(Set<Libro> libros);

	Set<Libro> findLibrosByNombre(List<String> nombresLibros);

	Asignatura getAsignaturaByNombre(String asignatura);

}
