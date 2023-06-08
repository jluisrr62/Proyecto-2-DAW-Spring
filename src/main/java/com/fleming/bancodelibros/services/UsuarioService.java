package com.fleming.bancodelibros.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.fleming.bancodelibros.controller.dto.ResponseDTO;
import com.fleming.bancodelibros.controller.dto.UserDTO;
import com.fleming.bancodelibros.modelo.Usuario;

public interface UsuarioService extends UserDetailsService{

	Usuario findByUsername(String username);

	ResponseDTO generarResponseDto(UserDTO user, Authentication auth);
	
}
