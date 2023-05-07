package com.fleming.bancodelibros.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.modelo.Recogida;

public interface RecogidaService {

	List<LocalDateTime> getFechasPorAlumnoId(Long id);

	Set<Recogida> getRecogidasPorAlumnoId(Long id);
	
}
