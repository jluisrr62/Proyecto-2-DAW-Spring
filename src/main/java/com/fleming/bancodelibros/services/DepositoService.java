package com.fleming.bancodelibros.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fleming.bancodelibros.modelo.Deposito;

public interface DepositoService {

	Set<Deposito> getDepositosPorAdminId(Long adminId);
	List<LocalDateTime> getFechasPorAdminId(Long adminID);
}	
