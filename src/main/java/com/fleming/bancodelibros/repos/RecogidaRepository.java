package com.fleming.bancodelibros.repos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.modelo.RecogidaId;

public interface RecogidaRepository extends JpaRepository<Recogida, RecogidaId>{

	List<LocalDateTime> findIdFechaByAlumnoId(Long id);

	Set<Recogida> findByAlumnoId(Long id);

	Set<Recogida> findByLibroId(Long id);

	@Query("SELECT r FROM Recogida r WHERE r.alumno.nombreUsuario = :username")
	List<Recogida> getByUsername(String username);

}
