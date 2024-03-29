package com.fleming.bancodelibros.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.controller.dto.NuevaRecogidaDto;
import com.fleming.bancodelibros.controller.dto.RecogidaDto;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.modelo.RecogidaId;

public interface RecogidaService {

	RecogidaDto createRecogida(NuevaRecogidaDto recogidaDto);
	RecogidaDto updateRecogida(RecogidaDto recogida);
	Recogida getRecogida(RecogidaId id);
	RecogidaDto getRecogidaDto(String dni, String isbn, LocalDateTime fecha);
	List<Recogida> getRecogidas();
	void deleteRecogida(String dni, String isbn, LocalDateTime fecha);
	
	List<LocalDateTime> getFechasPorAlumnoId(Long id);

	Set<Recogida> getRecogidasPorAlumnoId(Long id);

	List<LocalDateTime> getFechasRecogidas(Set<Recogida> recogidas);
	List<RecogidaDto> getRecogidasDto();
	Set<Recogida> getRecogidasByLibroId(Long id);
	LocalDateTime generateFechaNuevaRecogida();
	List<RecogidaDto> getRecogidasDtoByUsername(String username);
}
