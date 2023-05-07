package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.repos.DepositoRepository;
import com.fleming.bancodelibros.services.DepositoService;

public class DepositoServiceImpl implements DepositoService{
	
	@Autowired
	DepositoRepository depositoRepo;
	
	@Override
	public List<LocalDateTime> getFechasPorAdminId(Long adminId) {
		List<LocalDateTime> fechas = new ArrayList<>();
		
		for (Deposito depo : depositoRepo.findAll()) {
			if(depo.getAdmin().getId() == adminId) 
				fechas.add(depo.getId().getFecha());
		}
		
		return fechas;
	}

}
