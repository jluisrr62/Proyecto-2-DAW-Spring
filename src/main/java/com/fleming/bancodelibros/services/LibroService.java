package com.fleming.bancodelibros.services;

import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.controller.dto.LibroDto;
import com.fleming.bancodelibros.modelo.Libro;


public interface LibroService {
	LibroDto createLibro(LibroDto libro);
	LibroDto updateLibro(LibroDto libro);
	Libro getLibro(Long id);
	List<Libro> getLibros();
	void deleteLibro(Long id);
	
	void generarLibros();
	LibroDto getLibroDto(Long id);
	List<LibroDto> getLibrosDto();
	Libro getLibroByIsbn(String isbn);
	Set<Libro> findLibrosByNombre(List<String> nombresLibros);

}
