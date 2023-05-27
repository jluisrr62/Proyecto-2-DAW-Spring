package com.fleming.bancodelibros.services;

import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.controller.dto.AsignaturaDto;
import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;

public interface AsignaturaService {

	List<String> getNombresByLibros(Set<Libro> libros);

	Asignatura getAsignaturaByNombre(String asignatura);

	AsignaturaDto createAsignaturaDto(AsignaturaDto asignaturaDto);

	List<AsignaturaDto> getAsignaturasDto();

	AsignaturaDto getAsignaturaDto(Long id);

	AsignaturaDto updateAsignaturaDto(AsignaturaDto asignaturaDto);

	void deleteAsignatura(Long id);

}
