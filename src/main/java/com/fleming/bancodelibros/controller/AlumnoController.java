package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.interfaces.AlumnoRepository;
import com.fleming.bancodelibros.modelo.Alumno;


@RequestMapping("/alumnos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {
	@Autowired
	private final AlumnoRepository alumnoRepository = null;
	
	@GetMapping
	public List<Alumno> getAlumnos() {
        return (List<Alumno>) alumnoRepository.findAll();
    }
	
	@PostMapping
	public void addAlumno(@RequestBody Alumno alumno) {
        alumnoRepository.save(alumno);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAlumno(@PathVariable("id") Integer idAlumno) {
		alumnoRepository.deleteById(idAlumno);
	}
	
	@PutMapping("/{id}")
	public void updateAlumno(@PathVariable("id") Integer idAlumno, @RequestBody Alumno alumno) {
		System.out.println("actualizado el alumno " + alumno.getNombre());
		
		Alumno alumnoUpdate = alumnoRepository.findById(idAlumno).orElseThrow();
		
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setnUsuario(alumno.getnUsuario());
		alumnoUpdate.setContrasenia(alumno.getContrasenia());
		
		alumnoRepository.save(alumnoUpdate);
	}
}
