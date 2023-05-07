package com.fleming.bancodelibros.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
		
		if(admin.getDepositos() == null || admin.getDepositos().size() == 0) {
			respuesta.setDepositos(new ArrayList<LocalDateTime>());
		}else {
			respuesta.setDepositos(depositoService.getFechasPorAdminId(admin.getId()));
		}
		
		return respuesta;
	}

	@Override
	public Admin dtoToAdmin(AdminDto adminDto) {
		
		return null;
	}

	@Override
	public AlumnoDto alumnoToDto(Alumno alumno) {
		
		return null;
	}

	@Override
	public Alumno dtoToAlumno(AlumnoDto alumnoDto) {
		
		return null;
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
