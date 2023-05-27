package com.fleming.bancodelibros.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.controller.dto.DepositoDto;
import com.fleming.bancodelibros.modelo.Deposito;

public interface DepositoService {

	Set<Deposito> getDepositosPorAdminId(Long adminId);
	List<LocalDateTime> getFechasPorAdminId(Long adminID);
	List<LocalDateTime> getFechasDepositos(Set<Deposito> depositos);
	Set<Deposito> getDepositosByLibroId(Long id);
	DepositoDto createDepositoDto(DepositoDto depositoDto);
	List<DepositoDto> getDepositosDto();
	DepositoDto getDepositoDto(String nColegiado, String isbn, LocalDateTime fecha);
	DepositoDto updateDepositoDto(DepositoDto depositoDto);
	void deleteDeposito(String nColegiado, String isbn, LocalDateTime fecha);
	
}	
