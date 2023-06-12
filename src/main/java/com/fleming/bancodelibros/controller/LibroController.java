package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.fleming.bancodelibros.controller.dto.LibroDto;
import com.fleming.bancodelibros.services.LibroService;

@RequestMapping("/libros")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDto> createLibro(@RequestBody @Validated LibroDto libroDto) {
		LibroDto respuesta = libroService.createLibro(libroDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibroDto>> getLibros() {
		List<LibroDto> respuesta = libroService.getLibrosDto();
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDto> getLibro(@RequestParam Long id) {
		LibroDto respuesta = libroService.getLibroDto(id);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@PutMapping(path = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDto> updateLibro(@RequestBody @Validated LibroDto libroDto) {
		LibroDto respuesta = libroService.updateLibro(libroDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLibro(@RequestParam Long id) {
		
		libroService.deleteLibro(id);		
	}
}
