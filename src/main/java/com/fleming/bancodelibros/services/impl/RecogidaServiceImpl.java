package com.fleming.bancodelibros.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.NuevaRecogidaDto;
import com.fleming.bancodelibros.controller.dto.RecogidaDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.modelo.RecogidaId;
import com.fleming.bancodelibros.repos.RecogidaRepository;
import com.fleming.bancodelibros.services.AlumnoService;
import com.fleming.bancodelibros.services.LibroService;
import com.fleming.bancodelibros.services.RecogidaService;
import com.fleming.bancodelibros.utils.BancoDeLibrosConstants;

@Service
public class RecogidaServiceImpl implements RecogidaService{
	
	@Autowired
	private RecogidaRepository recogidaRepo;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private MapperService mapper;
	
	@Override
	public RecogidaDto createRecogida(NuevaRecogidaDto recogidaDto) {
		
		Recogida recogida = mapper.dtoNuevoToRecogida(recogidaDto);
		
		return mapper.recogidaToDto(recogidaRepo.save(recogida));
	}

	@Override
	public RecogidaDto updateRecogida(RecogidaDto recogidaDto) {
		Recogida recogida = mapper.dtoToRecogida(recogidaDto);
		
		return mapper.recogidaToDto(recogidaRepo.save(recogida));
	}

	@Override
	public Recogida getRecogida(RecogidaId id) {
		
		return recogidaRepo.findById(id).get();
	}
	
	@Override
	public RecogidaDto getRecogidaDto(String dni, String isbn, LocalDateTime fecha) {
		
		RecogidaId id = new RecogidaId();
		id.setAlumnoId(alumnoService.getAlumnoByDni(dni) == null ? null :  alumnoService.getAlumnoByDni(dni).getId());
		id.setLibroId(libroService.getLibroByIsbn(isbn) == null ? null : libroService.getLibroByIsbn(isbn).getId());
		id.setFecha(fecha);
		
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
	public void deleteRecogida(String dni, String isbn, LocalDateTime fecha) {
		RecogidaId id = new RecogidaId();
		id.setAlumnoId(alumnoService.getAlumnoByDni(dni) == null ? null :  alumnoService.getAlumnoByDni(dni).getId());
		id.setLibroId(libroService.getLibroByIsbn(isbn) == null ? null : libroService.getLibroByIsbn(isbn).getId());
		id.setFecha(fecha);
		
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

	
	@Override
	public LocalDateTime generateFechaNuevaRecogida() {
		
		if(recogidaRepo.findAll().size() > 0) {
			Recogida ultimaRecogida = recogidaRepo.findAll().get(recogidaRepo.findAll().size()-1);
			LocalDateTime ultimaFecha = ultimaRecogida.getId().getFecha();
			LocalDateTime nuevaFecha = null;
			
			if(ultimaFecha.getHour() == BancoDeLibrosConstants.Horarios.CIERRE)
				nuevaFecha = ultimaFecha.plusDays(1).withHour(BancoDeLibrosConstants.Horarios.APERTURA);
			else 
				nuevaFecha = ultimaFecha.plusMinutes(BancoDeLibrosConstants.Intervalos.ENTRE_RECOGIDAS);
			
			return nuevaFecha;
		}
		return LocalDateTime.now().plusDays(1).withHour(BancoDeLibrosConstants.Horarios.APERTURA);
	}
	
}
