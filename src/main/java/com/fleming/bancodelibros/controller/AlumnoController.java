package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.controller.dto.AlumnoDto;
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
	
	@GetMapping(path = "/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoDto>> getAlumnos() {
		List<AlumnoDto> respuesta = alumnoService.getAlumnosDto();
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoDto> getAlumno(@RequestParam Long id) {
		AlumnoDto respuesta = alumnoService.getAlumnoDto(id);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
		
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoDto> addAlumno(@RequestBody AlumnoDto alumnoDto) {
		AlumnoDto respuesta = alumnoService.createYupdateAlumno(alumnoDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
	
	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAlumno(@RequestParam Long id) {
		alumnoService.deleteAlumno(id);

	}
	
	@PutMapping(path = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoDto> updateAlumno(@RequestBody AlumnoDto alumnoDto) {
		AlumnoDto respuesta = alumnoService.createYupdateAlumno(alumnoDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
	
}
