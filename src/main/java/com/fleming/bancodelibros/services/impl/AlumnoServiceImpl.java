package com.fleming.bancodelibros.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.AlumnoDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.repos.AlumnoRepository;
import com.fleming.bancodelibros.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private MapperService mapper;

	@Override
	public AlumnoDto createYupdateAlumno(AlumnoDto alumnoDto) {
		
		Alumno alumno = mapper.dtoToAlumno(alumnoDto);
		
		
		return mapper.alumnoToDto(alumnoRepo.save(alumno));
	}

	@Override
	public Alumno getAlumno(Long id) {
		
		return alumnoRepo.findById(id).get();
	}

	@Override 
	public AlumnoDto getAlumnoDto(Long id) {
		
		return mapper.alumnoToDto(getAlumno(id));
	}
	
	@Override
	public List<Alumno> getAlumnos() {
		
		return alumnoRepo.findAll();
	}
	
	@Override
	public List<AlumnoDto> getAlumnosDto(){
		
		List<AlumnoDto> respuesta = new ArrayList<>();
		
		for (Alumno alumno : getAlumnos()) {
			
			respuesta.add(mapper.alumnoToDto(alumno));
		}
		
		return respuesta;
	}


	@Override
	public void deleteAlumno(Long id) {
		
		alumnoRepo.deleteById(id);
	}

	@Override
	public void generarAlumnos() {
	
		
		Alumno a1 = new Alumno("717564691B", "Jose", "jhifoew", "rgowv");
		Alumno a2 = new Alumno("717564691C", "Jaime", "jhifoew", "rgowv");
		
		alumnoRepo.save(a1);
		alumnoRepo.save(a2);
		
	}


}
