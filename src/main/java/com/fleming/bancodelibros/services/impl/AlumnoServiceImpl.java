package com.fleming.bancodelibros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.repos.AlumnoRepository;
import com.fleming.bancodelibros.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Override
	public Alumno createAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepo.save(alumno);
	}

	@Override
	public Alumno getAlumno(Integer id) {
		// TODO Auto-generated method stub
		return alumnoRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoRepo.findAll();
	}

	@Override
	public Alumno updateAlumno(Integer id, Alumno alumno) {
		// TODO Auto-generated method stub
		
		Alumno alumnoUpdate = alumnoRepo.findById(id).orElseThrow();
		
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setnUsuario(alumno.getnUsuario());
		alumnoUpdate.setContrasenia(alumno.getContrasenia());
		
		
		
		return alumnoRepo.save(alumnoUpdate);
	}

	@Override
	public void deleteAlumno(Integer id) {
		// TODO Auto-generated method stub
		alumnoRepo.deleteById(id);
	}

	@Override
	public void generarAlumnos() {
		// TODO Auto-generated method stub
		
		Alumno a1 = new Alumno("717564691B", "Jose", "jhifoew", "rgowv");
		Alumno a2 = new Alumno("717564691C", "Jaime", "jhifoew", "rgowv");
		
		alumnoRepo.save(a1);
		alumnoRepo.save(a2);
		
	}

}
