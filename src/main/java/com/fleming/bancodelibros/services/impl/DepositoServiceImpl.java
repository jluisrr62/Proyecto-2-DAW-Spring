package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.DepositoDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.modelo.DepositoId;
import com.fleming.bancodelibros.repos.DepositoRepository;
import com.fleming.bancodelibros.services.AdminService;
import com.fleming.bancodelibros.services.DepositoService;
import com.fleming.bancodelibros.services.LibroService;

@Service
public class DepositoServiceImpl implements DepositoService{
	
	@Autowired
	DepositoRepository depositoRepo;
	
	@Autowired
	@Lazy
	AdminService adminService;
	
	@Autowired
	@Lazy
	LibroService libroService;
	
	@Autowired
	MapperService mapperService;
	
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

	@Override
	public DepositoDto createDepositoDto(DepositoDto depositoDto) {
		Deposito deposito = mapperService.dtoToDeposito(depositoDto);
		Deposito creada = depositoRepo.save(deposito);
		
		return mapperService.depositoToDto(creada);
	}

	@Override
	public List<DepositoDto> getDepositosDto() {
		
		return mapperService.depositosToDtos(depositoRepo.findAll());
	}

	@Override
	public DepositoDto getDepositoDto(String nColegiado, String isbn, LocalDateTime fecha) {		
		DepositoId id = new DepositoId();
		id.setAdminId(adminService.getAdminByNumeroColegiado(nColegiado) == null ? null : adminService.getAdminByNumeroColegiado(nColegiado).getId());
		id.setFecha(fecha);
		id.setLibroId(libroService.getLibroByIsbn(isbn) == null ? null : libroService.getLibroByIsbn(isbn).getId());
		
		return depositoRepo.findById(id).isPresent() ? mapperService.depositoToDto(depositoRepo.findById(id).get()) : null; 
	}

	@Override
	public DepositoDto updateDepositoDto(DepositoDto depositoDto) {
		Deposito deposito = mapperService.dtoToDeposito(depositoDto);
		Deposito actualizada = depositoRepo.save(deposito);
		
		return mapperService.depositoToDto(actualizada);
	}

	@Override
	public void deleteDeposito(String nColegiado, String isbn, LocalDateTime fecha) {
		DepositoId id = new DepositoId();
		id.setAdminId(adminService.getAdminByNumeroColegiado(nColegiado) == null ? null : adminService.getAdminByNumeroColegiado(nColegiado).getId());
		id.setFecha(fecha);
		id.setLibroId(libroService.getLibroByIsbn(isbn) == null ? null : libroService.getLibroByIsbn(isbn).getId());
		
		depositoRepo.deleteById(id);
	}

}
