package com.fleming.bancodelibros.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleming.bancodelibros.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

	Libro findByIsbn(String isbn);

	Set<Libro> findByNombreIn(List<String> nombresLibros);

}
