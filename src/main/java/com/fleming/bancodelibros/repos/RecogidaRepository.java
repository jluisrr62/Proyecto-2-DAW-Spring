package com.fleming.bancodelibros.repos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleming.bancodelibros.modelo.Recogida;

public interface RecogidaRepository extends JpaRepository<Recogida, Long>{

	List<LocalDateTime> findIdFechaByAlumnoId(Long id);

	Set<Recogida> findByAlumnoId(Long id);

	Set<Recogida> findByLibroId(Long id);

}