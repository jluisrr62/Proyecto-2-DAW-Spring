package com.fleming.bancodelibros.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

	@Query("SELECT a.nombre FROM Asignatura a, Libro l WHERE l.asignatura.id = a.id AND l IN :libros")
	List<String> encontrarNombresByLibros(Set<Libro> libros);

	Asignatura findByNombre(String asignatura);

}
