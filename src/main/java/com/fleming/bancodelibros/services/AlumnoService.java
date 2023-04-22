package com.fleming.bancodelibros.services;

import java.util.List;

import com.fleming.bancodelibros.modelo.Alumno;

public interface AlumnoService {
	public Alumno createAlumno(Alumno alumno);
	public Alumno getAlumno(Integer id);
	public List<Alumno> getAlumnos();
	public Alumno updateAlumno(Integer id, Alumno alumno);
	public void deleteAlumno(Integer id);
	
	
	public void generarAlumnos();
}
