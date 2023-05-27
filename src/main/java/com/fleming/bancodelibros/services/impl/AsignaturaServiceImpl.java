package com.fleming.bancodelibros.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.controller.dto.AsignaturaDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.repos.AsignaturaRepository;
import com.fleming.bancodelibros.services.AsignaturaService;

public class AsignaturaServiceImpl implements AsignaturaService{

	@Autowired
	private AsignaturaRepository asignaturaRepo;
	
	@Autowired
	private MapperService mapperService;
	
	@Override
	public List<String> getNombresByLibros(Set<Libro> libros) {
		
		return asignaturaRepo.encontrarNombresByLibros(libros);
	}

	@Override
	public Asignatura getAsignaturaByNombre(String asignatura) {
		
		return asignaturaRepo.findByNombre(asignatura);
	}

	@Override
	public AsignaturaDto createAsignaturaDto(AsignaturaDto asignaturaDto) {
		Asignatura asignatura = mapperService.dtoToAsignatura(asignaturaDto);
		Asignatura creada = asignaturaRepo.save(asignatura);
		
		return mapperService.asignaturaToDto(creada);
	}

	@Override
	public List<AsignaturaDto> getAsignaturasDto() {
		
		return mapperService.asignaturasToDtos(asignaturaRepo.findAll());
	}

	@Override
	public AsignaturaDto getAsignaturaDto(Long id) {
		
		return asignaturaRepo.findById(id).isPresent() ? mapperService.asignaturaToDto(asignaturaRepo.findById(id).get()) : null; 
	}

	@Override
	public AsignaturaDto updateAsignaturaDto(AsignaturaDto asignaturaDto) {
		Asignatura asignatura = mapperService.dtoToAsignatura(asignaturaDto);
		Asignatura actualizada = asignaturaRepo.save(asignatura);
		
		return mapperService.asignaturaToDto(actualizada);
	}

	@Override
	public void deleteAsignatura(Long id) {
		
		asignaturaRepo.deleteById(id);
	}

}
