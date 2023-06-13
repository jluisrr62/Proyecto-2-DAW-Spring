package com.fleming.bancodelibros.controller;

import java.time.LocalDateTime;
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

import com.fleming.bancodelibros.controller.dto.DepositoDto;
import com.fleming.bancodelibros.controller.dto.NuevoDepositoDto;
import com.fleming.bancodelibros.services.DepositoService;

@RequestMapping("/depositos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepositoController {
	@Autowired
	private DepositoService depositoService;
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepositoDto> createDeposito(@RequestBody @Validated NuevoDepositoDto depositoDto) {
		DepositoDto respuesta = depositoService.createDepositoDto(depositoDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DepositoDto>> getDepositos() {
		List<DepositoDto> respuesta = depositoService.getDepositosDto();
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepositoDto> getDeposito(@RequestParam String nColegiado, @RequestParam String isbn, @RequestParam LocalDateTime fecha) {
		DepositoDto respuesta = depositoService.getDepositoDto(nColegiado,nColegiado,fecha);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@PutMapping(path = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepositoDto> updateDeposito(@RequestBody @Validated DepositoDto depositoDto) {
		DepositoDto respuesta = depositoService.updateDepositoDto(depositoDto);
		
		return respuesta == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
	
	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDeposito(@RequestParam String nColegiado, @RequestParam String isbn, @RequestParam LocalDateTime fecha) {
		
		depositoService.deleteDeposito(nColegiado,isbn,fecha);		
	}
}
