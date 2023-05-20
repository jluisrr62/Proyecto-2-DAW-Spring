package com.fleming.bancodelibros.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.AdminDto;
import com.fleming.bancodelibros.controller.dto.AlumnoDto;
import com.fleming.bancodelibros.controller.dto.AsignaturaDto;
import com.fleming.bancodelibros.controller.dto.DepositoDto;
import com.fleming.bancodelibros.controller.dto.LibroDto;
import com.fleming.bancodelibros.controller.dto.RecogidaDto;
import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.modelo.DepositoId;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.modelo.RecogidaId;
import com.fleming.bancodelibros.services.AdminService;
import com.fleming.bancodelibros.services.AlumnoService;
import com.fleming.bancodelibros.services.AsignaturaService;
import com.fleming.bancodelibros.services.DepositoService;
import com.fleming.bancodelibros.services.LibroService;
import com.fleming.bancodelibros.services.RecogidaService;

@Service
public class MapperServiceImpl implements MapperService{

	@Autowired
	@Lazy
	AdminService adminService;
	
	@Autowired
	@Lazy
	DepositoService depositoService;
	
	@Autowired
	@Lazy
	AlumnoService alumnoService;
	
	@Autowired
	@Lazy
	AsignaturaService asignaturaService;
	
	@Autowired
	@Lazy
	LibroService libroService;
	
	@Autowired
	@Lazy
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
		
		AsignaturaDto respuesta = new AsignaturaDto();
		
		respuesta.setId(asignatura.getId());
		respuesta.setNombre(asignatura.getNombre());
		respuesta.setCurso(asignatura.getCurso());
		respuesta.setNombresLibros(asignaturaService.getNombresByLibros(asignatura.getLibros()));
		
		return respuesta;
	}

	@Override
	public Asignatura dtoToAsignatura(AsignaturaDto asignaturaDto) {
		
		Asignatura respuesta = new Asignatura();
		
		respuesta.setId(asignaturaDto.getId());
		respuesta.setNombre(asignaturaDto.getNombre());
		respuesta.setCurso(asignaturaDto.getCurso());
		respuesta.setLibros(libroService.findLibrosByNombre(asignaturaDto.getNombresLibros()));
		
		return respuesta;
	}

	@Override
	public DepositoDto depositoToDto(Deposito deposito) {
		
		DepositoDto respuesta = new DepositoDto(); 
		
		respuesta.setIsbn(deposito.getLibro().getIsbn());
		respuesta.setnColegiado(deposito.getAdmin().getnColegiado());
		respuesta.setFecha(deposito.getId().getFecha());
		
		return respuesta;
	}

	@Override
	public Deposito dtoToDeposito(DepositoDto depositoDto) {
		Deposito respuesta = new Deposito();
		
		DepositoId id = new DepositoId();
		
		Admin admin = adminService.getAdminByNumeroColegiado(depositoDto.getnColegiado());
		Libro libro = libroService.getLibroByIsbn(depositoDto.getIsbn());
		
		id.setAdminId(admin.getId());
		id.setLibroId(libro.getId());
		id.setFecha(depositoDto.getFecha());
		
		respuesta.setId(id);
		respuesta.setAdmin(admin);
		respuesta.setLibro(libro);
		
		return respuesta;
	}

	@Override
	public LibroDto libroToDto(Libro libro) {
		
		LibroDto respuesta = new LibroDto();
		
		respuesta.setId(libro.getId());
		respuesta.setIsbn(libro.getIsbn());
		respuesta.setNombre(libro.getNombre());
		respuesta.setAsignatura(libro.getAsignatura().getNombre());
		respuesta.setFechasDepositos(depositoService.getFechasDepositos(libro.getDepositos()));
		respuesta.setFechasRecogidas(recogidaService.getFechasRecogidas(libro.getRecogidas()));
		
		return respuesta;
	}

	@Override
	public Libro dtoToLibro(LibroDto libroDto) {
		
		Libro respuesta = new Libro();
		
		respuesta.setId(libroDto.getId());
		respuesta.setIsbn(libroDto.getIsbn());
		respuesta.setNombre(libroDto.getNombre());
		respuesta.setAsignatura(asignaturaService.getAsignaturaByNombre(libroDto.getAsignatura()));
		respuesta.setDepositos(depositoService.getDepositosByLibroId(libroDto.getId()));
		respuesta.setRecogidas(recogidaService.getRecogidasByLibroId(libroDto.getId()));
		
		return respuesta;
	}
	
	@Override 
	public RecogidaDto recogidaToDto(Recogida recogida) {
		RecogidaDto respuesta = new RecogidaDto();
		
		respuesta.setDni(recogida.getAlumno().getDni());
		respuesta.setFecha(recogida.getId().getFecha());
		respuesta.setIsbn(recogida.getLibro().getIsbn());
		
		return respuesta;
	}
	
	@Override
	public Recogida dtoToRecogida(RecogidaDto recogidaDto) {
		Recogida respuesta = new Recogida();
		RecogidaId id = new RecogidaId();
		Libro libro = libroService.getLibroByIsbn(recogidaDto.getIsbn());
		Alumno alumno = alumnoService.getAlumnoByDni(recogidaDto.getDni());
		
		id.setAlumnoId(alumno.getId());
		id.setFecha(recogidaDto.getFecha());
		id.setLibroId(libro.getId());
		
		respuesta.setId(id);
		respuesta.setAlumno(alumno);
		respuesta.setLibro(libro);
	
		return respuesta;
	}
	
	@Override
	public List<AdminDto> adminsToDtos(List<Admin> admins) {
		List<AdminDto> respuesta = new ArrayList<>();
		
		for (Admin admin : admins) {
			
			respuesta.add(adminToDto(admin));
		}
		
		return respuesta;
		
	}
	
	@Override
	public List<AlumnoDto> alumnosToDtos(List<Alumno> alumnos){
		List<AlumnoDto> respuesta = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			
			respuesta.add(alumnoToDto(alumno));
		}
		
		return respuesta;
	}

	@Override
	public List<LibroDto> librosToDtos(List<Libro> libros) {
		List<LibroDto> respuesta = new ArrayList<>();
		
		for (Libro libro : libros) {
			
			respuesta.add(libroToDto(libro));
		}
		
		return respuesta;
	}

	@Override
	public List<RecogidaDto> recogidasToDtos(List<Recogida> recogidas) {
		List<RecogidaDto> respuesta = new ArrayList<>();
		
		for (Recogida recogida : recogidas) {
			
			respuesta.add(recogidaToDto(recogida));
		}
		
		return respuesta;
	}

}
