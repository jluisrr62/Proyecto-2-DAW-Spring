package com.fleming.bancodelibros.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fleming.bancodelibros.modelo.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	Usuario findByNombreUsuario(String Username);
}
