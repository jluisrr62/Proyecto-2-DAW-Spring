package com.fleming.bancodelibros.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleming.bancodelibros.controller.dto.AdminDto;
import com.fleming.bancodelibros.controller.dto.AlumnoDto;
import com.fleming.bancodelibros.controller.dto.AsignaturaDto;
import com.fleming.bancodelibros.controller.dto.DepositoDto;
import com.fleming.bancodelibros.controller.dto.LibroDto;
import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.services.AdminService;
import com.fleming.bancodelibros.services.AlumnoService;
import com.fleming.bancodelibros.services.AsignaturaService;
import com.fleming.bancodelibros.services.DepositoService;
import com.fleming.bancodelibros.services.LibroService;
import com.fleming.bancodelibros.services.RecogidaService;

public class MapperServiceImpl implements MapperService{

	@Autowired
	AdminService adminService;
	
	@Autowired
	DepositoService depositoService;
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	AsignaturaService asignaturaService;
	
	@Autowired
	LibroService libroService;
	
	@Autowired
	RecogidaService recogidaService;
	
	@Override
	public AdminDto adminToDto(Admin admin) {
		
		AdminDto respuesta = new AdminDto();
		
		respuesta.setId(admin.getId());
		respuesta.setDni(admin.getDni());
		respuesta.setNombre(admin.getNombre());
		respuesta.setnUsuario(admin.getnUsuario());
		respuesta.setContrasenia(admin.getContrasenia());
		respuesta.setnColegiado(admin.getnColegiado());
		
		if(admin.getDepositos() == null || admin.getDepositos().isEmpty()) {
			respuesta.setDepositos(new ArrayList<LocalDateTime>());
		}else {
			respuesta.setDepositos(depositoService.getFechasPorAdminId(admin.getId()));
		}
		
		return respuesta;
	}

	@Override
	public Admin dtoToAdmin(AdminDto adminDto) {
		
		Admin respuesta = new Admin();
		
		respuesta.setId(adminDto.getId());
		respuesta.setDni(adminDto.getDni());
		respuesta.setNombre(adminDto.getNombre());
		respuesta.setnUsuario(adminDto.getnUsuario());
		respuesta.setContrasenia(adminDto.getContrasenia());
		respuesta.setnColegiado(adminDto.getnColegiado());
		
		if(adminDto.getDepositos() == null || adminDto.getDepositos().isEmpty()) {
			respuesta.setDepositos(new HashSet<Deposito>());
		}else {
			respuesta.setDepositos(depositoService.getDepositosPorAdminId(adminDto.getId()));
		}
		
		return respuesta;
	}

	@Override
	public AlumnoDto alumnoToDto(Alumno alumno) {
		
		AlumnoDto respuesta = new AlumnoDto();
		
		respuesta.setId(alumno.getId());
		respuesta.setDni(alumno.getDni());
		respuesta.setNombre(alumno.getNombre());
		respuesta.setnUsuario(alumno.getnUsuario());
		respuesta.setContrasenia(alumno.getContrasenia());
		
		if(alumno.getRecogidas() == null || alumno.getRecogidas().isEmpty()) {
			respuesta.setRecogidas(new ArrayList<LocalDateTime>());
		}else {
			respuesta.setRecogidas(recogidaService.getFechasPorAlumnoId(alumno.getId()));
		}
		
		return respuesta;
	}

	@Override
	public Alumno dtoToAlumno(AlumnoDto alumnoDto) {
		
		Alumno respuesta = new Alumno();
		
		respuesta.setId(alumnoDto.getId());
		respuesta.setDni(alumnoDto.getDni());
		respuesta.setNombre(alumnoDto.getNombre());
		respuesta.setnUsuario(alumnoDto.getnUsuario());
		respuesta.setContrasenia(alumnoDto.getContrasenia());
		
		if(alumnoDto.getRecogidas() == null || alumnoDto.getRecogidas().isEmpty()) {
			respuesta.setRecogidas(new HashSet<Recogida>());
		}else {
			respuesta.setRecogidas(recogidaService.getRecogidasPorAlumnoId(alumnoDto.getId()));
		}
		
		return respuesta;
	}

	@Override
	public AsignaturaDto asignaturaToDto(Asignatura asignatura) {
		
		return null;
	}

	@Override
	public Asignatura dtoToAsignatura(AsignaturaDto asignaturaDto) {
		
		return null;
	}

	@Override
	public DepositoDto depositoToDto(Deposito deposito) {
		
		return null;
	}

	@Override
	public Deposito dtoToDeposito(DepositoDto depositoDto) {
		
		return null;
	}

	@Override
	public LibroDto libroToDto(Libro libro) {
		
		return null;
	}

	@Override
	public Libro dtoToLibro(LibroDto libroDto) {
		
		return null;
	}

}
