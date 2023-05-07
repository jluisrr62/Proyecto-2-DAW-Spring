package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.repos.DepositoRepository;
import com.fleming.bancodelibros.services.DepositoService;

public class DepositoServiceImpl implements DepositoService{
	
	@Autowired
	DepositoRepository depositoRepo;
	
	@Override
	public Set<Deposito> getDepositosPorAdminId(Long adminId) {
		Set<Deposito> depositos = new HashSet<>();
		
		for (Deposito depo : depositoRepo.findAll()) {
			if(depo.getAdmin().getId() == adminId) 
				depositos.add(depo);
		}
		
		return depositos;
	}

	@Override
	public List<LocalDateTime> getFechasPorAdminId(Long adminID) {
		
		List<LocalDateTime> fechas = new ArrayList<>();
		
		for (Deposito deposito : depositoRepo.findAll()) {
			fechas.add(deposito.getId().getFecha());
		}
		
		return fechas;
	}

}
