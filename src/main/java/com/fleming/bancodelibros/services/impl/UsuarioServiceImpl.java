package com.fleming.bancodelibros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.ResponseDTO;
import com.fleming.bancodelibros.controller.dto.UserDTO;
import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.modelo.Usuario;
import com.fleming.bancodelibros.repos.UsuarioRepository;
import com.fleming.bancodelibros.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private SessionRegistry sessionRegistry;

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepo.findByNombreUsuario(username);
	}

	@Override
	public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
		final Usuario user = usuarioRepo.findByNombreUsuario(username);
        if (user != null) {
            final Usuario currentUser = user instanceof Admin ?  new Admin() : new Alumno();
            currentUser.setnUsuario(user.getnUsuario());
            currentUser.setContrasenia(user.getContrasenia());

            return currentUser;
        }

        final Usuario currentUser = usuarioRepo.findByNombreUsuario(username);
        if (currentUser == null) {
            throw new UsernameNotFoundException("Failed to find user with username: " + username);
        }

        return currentUser;
    
	}
	


	@Override
	public ResponseDTO generarResponseDto(UserDTO user, Authentication auth) {
		List<SessionInformation> sessionInfo = sessionRegistry.getAllSessions(auth.getPrincipal(), false);
		ResponseDTO response = new ResponseDTO();
		if(sessionInfo.isEmpty()) {
			sessionRegistry.registerNewSession("token de" + user.getUsername(), auth.getPrincipal());
			response.setSessionId("token de " + user.getUsername());
			System.out.println("el token de " + user.getUsername() + " es nuevo");
		}else {
			
			response.setSessionId(sessionInfo.get(sessionInfo.size() -1).getSessionId());
			System.out.println("el token de " + response + " lo esta pillando");
		}
		
		for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
			if(grantedAuthority.getAuthority().equals("ADMIN"))
				response.setRol("admin");
			else
				response.setRol("alumno");
		}
	
		
		return response;
	}

}
