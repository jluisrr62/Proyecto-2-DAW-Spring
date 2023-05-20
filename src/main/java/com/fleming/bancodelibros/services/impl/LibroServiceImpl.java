package com.fleming.bancodelibros.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.LibroDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.repos.LibroRepository;
import com.fleming.bancodelibros.services.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepo;
	
	@Autowired
	private MapperService mapper;

	@Override
	public LibroDto createLibro(LibroDto libroDto) {
		
		Libro libro = mapper.dtoToLibro(libroDto); 
		
		return mapper.libroToDto(libroRepo.save(libro));
	}

	@Override
	public LibroDto updateLibro(LibroDto libroDto) {
		Libro libro = mapper.dtoToLibro(libroDto); 
		
		return mapper.libroToDto(libroRepo.save(libro));
	}

	@Override
	public Libro getLibro(Long id) {
		
		return libroRepo.findById(id).get();
	}
	
	@Override
	public LibroDto getLibroDto(Long id) {
		
		return mapper.libroToDto(getLibro(id));
	}
	
	@Override
	public Libro getLibroByIsbn(String isbn) {
		
		return libroRepo.findByIsbn(isbn);
	}
	
	@Override
	public List<Libro> getLibros() {
		
		return libroRepo.findAll();
	}

	@Override
	public List<LibroDto> getLibrosDto() {
		
		return mapper.librosToDtos(getLibros());
	}
	
	@Override
	public void deleteLibro(Long id) {
		
		libroRepo.deleteById(id);
	}

	@Override
	public void generarLibros() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Libro> findLibrosByNombre(List<String> nombresLibros) {
		
		return libroRepo.findByNombreIn(nombresLibros);
	}
}
