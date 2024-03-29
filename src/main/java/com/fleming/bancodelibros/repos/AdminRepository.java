package com.fleming.bancodelibros.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleming.bancodelibros.modelo.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByNumeroColegiado(String nColegiado);

	Admin findByNombreUsuario(String username);
}
