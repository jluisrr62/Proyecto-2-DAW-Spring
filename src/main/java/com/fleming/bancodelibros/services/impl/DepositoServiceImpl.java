package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
	
		return depositoRepo.findByAdminId(adminId);
	}

	@Override
	public List<LocalDateTime> getFechasPorAdminId(Long adminID) {
		
		return depositoRepo.findIdFechaByAdminId(adminID);
	}

	@Override
	public List<LocalDateTime> getFechasDepositos(Set<Deposito> depositos) {
		List<LocalDateTime> fechas = new ArrayList<>();
		
		for (Deposito deposito : depositos) {
			fechas.add(deposito.getId().getFecha());
		}
		
		return fechas;
	}

	@Override
	public Set<Deposito> getDepositosByLibroId(Long id) {
		
		return depositoRepo.findByLibroId(id);
	}

}
