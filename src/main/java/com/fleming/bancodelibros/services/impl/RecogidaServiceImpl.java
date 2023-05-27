package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.controller.dto.RecogidaDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.repos.RecogidaRepository;
import com.fleming.bancodelibros.services.RecogidaService;

public class RecogidaServiceImpl implements RecogidaService{
	
	@Autowired
	private RecogidaRepository recogidaRepo;
	
	@Autowired
	private MapperService mapper;
	
	@Override
	public RecogidaDto createRecogida(RecogidaDto recogidaDto) {
		
		Recogida recogida = mapper.dtoToRecogida(recogidaDto);
		
		return mapper.recogidaToDto(recogidaRepo.save(recogida));
	}

	@Override
	public RecogidaDto updateRecogida(RecogidaDto recogidaDto) {
		Recogida recogida = mapper.dtoToRecogida(recogidaDto);
		
		return mapper.recogidaToDto(recogidaRepo.save(recogida));
	}

	@Override
	public Recogida getRecogida(Long id) {
		
		return recogidaRepo.findById(id).get();
	}
	
	@Override
	public RecogidaDto getRecogidaDto(Long id) {
		
		return mapper.recogidaToDto(getRecogida(id));
	}

	@Override
	public List<Recogida> getRecogidas() {
		
		return recogidaRepo.findAll();
	}
	
	@Override
	public List<RecogidaDto> getRecogidasDto(){
		
		return mapper.recogidasToDtos(getRecogidas());
	}

	@Override
	public void deleteRecogida(Long id) {
		
		recogidaRepo.deleteById(id);
	}

	@Override
	public List<LocalDateTime> getFechasPorAlumnoId(Long id) {
		
		return recogidaRepo.findIdFechaByAlumnoId(id);
	}

	@Override
	public Set<Recogida> getRecogidasPorAlumnoId(Long id) {
		
		return recogidaRepo.findByAlumnoId(id);
	}

	@Override
	public List<LocalDateTime> getFechasRecogidas(Set<Recogida> recogidas) {
		List<LocalDateTime> fechas = new ArrayList<>();
		
		for (Recogida recogida : recogidas) {
			fechas.add(recogida.getId().getFecha());
		}
		
		return fechas;
	}

	@Override
	public Set<Recogida> getRecogidasByLibroId(Long id) {
		
		return recogidaRepo.findByLibroId(id);
	}
	
}