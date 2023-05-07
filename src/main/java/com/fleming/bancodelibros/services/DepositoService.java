package com.fleming.bancodelibros.services;

import java.time.LocalDateTime;
import java.util.List;

public interface DepositoService {
	List<LocalDateTime> getFechasPorAdminId(Long adminId);
}	
