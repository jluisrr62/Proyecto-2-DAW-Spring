package com.fleming.bancodelibros.services;

import java.util.List;

import com.fleming.bancodelibros.controller.dto.AlumnoDto;
import com.fleming.bancodelibros.modelo.Alumno;

public interface AlumnoService {
	AlumnoDto createYupdateAlumno(AlumnoDto alumno);
	Alumno getAlumno(Long id);
	AlumnoDto getAlumnoDto(Long id);
	List<Alumno> getAlumnos();
	List<AlumnoDto> getAlumnosDto();
	void deleteAlumno(Long id);
	
	void generarAlumnos();
	Alumno getAlumnoByDni(String dni);
	
	Alumno getByUsername(String username);
}
