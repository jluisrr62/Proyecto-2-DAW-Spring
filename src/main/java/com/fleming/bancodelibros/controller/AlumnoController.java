package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.services.AlumnoService;


@RequestMapping("/alumnos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	
	@PostMapping("/generar")
	public void generarAlumnos() {
		alumnoService.generarAlumnos();
	}
	
	
	@GetMapping
	public ResponseEntity<List<Alumno>> getAlumnos() {
		
		List<Alumno> alumnos = alumnoService.getAlumnos();
		
		if(alumnos == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(alumnos);
		}
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable("id") Integer idAlumno) {
		
		Alumno alumno = alumnoService.getAlumno(idAlumno);
		
		if(alumno == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(alumno);
		}
    }
		
	@PostMapping
	public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno) {
		
		Alumno alumnoCreated = alumnoService.createAlumno(alumno);;
		
		if(alumno == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(alumnoCreated);
		}
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable("id") Integer idAlumno) {
		alumnoService.deleteAlumno(idAlumno);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("id") Integer idAlumno, @RequestBody Alumno alumno) {
		Alumno alumnoUpdated = alumnoService.updateAlumno(idAlumno, alumno);
		
		if(alumnoUpdated == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(alumnoUpdated);
		}
	}
}
