package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.interfaces.AdminRepository;
import com.fleming.bancodelibros.interfaces.AlumnoRepository;
import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	@Autowired
	private final AlumnoRepository alumnoRepository = null;
	
	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos() {
        return (List<Alumno>) alumnoRepository.findAll();
    }
	
	@PostMapping("/alumnos")
	public void addAlumno(@RequestBody Alumno alumno) {
        alumnoRepository.save(alumno);
	}
	
	@DeleteMapping("/alumnos/{id}")
	public void deleteAlumno(@PathVariable("id") Integer idAlumno) {
		alumnoRepository.deleteById(idAlumno);
	}
	 
	@Autowired
	private final AdminRepository adminRepo = null; 
	 
	@GetMapping("/admins")
	public List<Admin> getAdmins() {
	    return (List<Admin>) adminRepo.findAll();
	}
		
	@PostMapping("/admins")
	public void addAdmins(@RequestBody Admin admin) {
		adminRepo.save(admin);
	}
}
