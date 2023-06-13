package com.fleming.bancodelibros.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.fleming.bancodelibros.controller.dto.NuevaRecogidaDto;
import com.fleming.bancodelibros.controller.dto.RecogidaDto;
import com.fleming.bancodelibros.services.RecogidaService;

@RequestMapping("/recogidas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecogidaController {
	@Autowired
	private RecogidaService recogidaService;
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecogidaDto> createRecogida(@RequestBody @Validated NuevaRecogidaDto recogidaDto) {
		RecogidaDto respuesta = recogidaService.createRecogida(recogidaDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecogidaDto>> getRecogidas() {
		List<RecogidaDto> respuesta = recogidaService.getRecogidasDto();
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecogidaDto> getRecogida(@RequestParam String dni, @RequestParam String isbn, @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss.SSS") LocalDateTime fecha) {

		RecogidaDto respuesta = recogidaService.getRecogidaDto(dni,isbn,fecha);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@PutMapping(path = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecogidaDto> updateRecogida(@RequestBody @Validated RecogidaDto recogidaDto) {
		RecogidaDto respuesta = recogidaService.updateRecogida(recogidaDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRecogida(@RequestParam String dni, @RequestParam String isbn, @RequestParam String fecha) {
		
		 DateTimeFormatter dateTimeFormat = 
		            DateTimeFormatter.ISO_DATE_TIME;
		 
		 LocalDateTime fechaFinal = dateTimeFormat.parse(fecha, LocalDateTime::from);
		
		recogidaService.deleteRecogida(dni,isbn,fechaFinal);		
	}
	
	@GetMapping(path = "/ByUsername", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecogidaDto>> getRecogidaByUsername(@RequestParam String username) {
		List<RecogidaDto> respuesta = recogidaService.getRecogidasDtoByUsername(username);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
}
