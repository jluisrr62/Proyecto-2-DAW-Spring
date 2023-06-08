package com.fleming.bancodelibros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fleming.bancodelibros.controller.dto.ResponseDTO;
import com.fleming.bancodelibros.controller.dto.UserDTO;
import com.fleming.bancodelibros.services.UsuarioService;

@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	 @Autowired
	 public AuthenticationManager manager;
	 
	 @Autowired
	 private UsuarioService usuarioService;
	 
	 @Autowired
	 public SessionRegistry sessionRegistry;


	 @PostMapping(path = "/login" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user) {

		System.out.println("probando");
		Authentication auth =  manager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
		);
		
		final ResponseDTO responseDto = usuarioService.generarResponseDto(user, auth);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("sessionAuths", "hola");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(responseDto);
	 }


}
