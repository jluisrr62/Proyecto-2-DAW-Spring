package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.persistencia.GenericDAO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
	
	private GenericDAO<Alumno> dao;
	
	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos() {
        return (List<Alumno>) dao.listarRegistrosHibernate("alumnos");
    }
	
	 @PostMapping("/alumnos")
	 public void addUser(@RequestBody Alumno alumno) {
	        dao.insertarRegistroHibernate(alumno);
	    }
}
