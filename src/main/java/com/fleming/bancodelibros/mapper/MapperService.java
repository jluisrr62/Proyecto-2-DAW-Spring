package com.fleming.bancodelibros.mapper;

import java.util.List;

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
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.modelo.Recogida;

public interface MapperService {
	
	AdminDto adminToDto(Admin admin);
	Admin dtoToAdmin(AdminDto adminDto);
	
	AlumnoDto alumnoToDto(Alumno alumno);
	Alumno dtoToAlumno(AlumnoDto alumnoDto);
	
	AsignaturaDto asignaturaToDto(Asignatura asignatura);
	Asignatura dtoToAsignatura(AsignaturaDto asignaturaDto);
	
	DepositoDto depositoToDto(Deposito deposito);
	Deposito dtoToDeposito(DepositoDto depositoDto);
	
	LibroDto libroToDto(Libro libro);
	Libro dtoToLibro(LibroDto libroDto);
	
	RecogidaDto recogidaToDto(Recogida recogida);
	Recogida dtoToRecogida(RecogidaDto recogidaDto);
	
	List<AdminDto> adminsToDtos(List<Admin> admins);
	List<AlumnoDto> alumnosToDtos(List<Alumno> alumnos);
	List<LibroDto> librosToDtos(List<Libro> libros);
	List<RecogidaDto> recogidasToDtos(List<Recogida> recogidas);
}
