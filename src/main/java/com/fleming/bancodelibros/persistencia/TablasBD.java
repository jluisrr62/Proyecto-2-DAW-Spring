package com.fleming.bancodelibros.persistencia;

import java.time.LocalDateTime;

import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.modelo.Asignatura;
import com.fleming.bancodelibros.modelo.Libro;
import com.fleming.bancodelibros.modelo.Recogida;
import com.fleming.bancodelibros.modelo.Usuario;


public class TablasBD {	
	public void crearTablas() {
		Alumno javi = new Alumno("734265B","Javier", "javierito", "123javier");
		Alumno juan = new Alumno("735876X","Juan", "juanito", "juanito89");
		Admin jorjito = new Admin("717255C","Jorge", "47891494", "jorjito67", "123456");
		
		Libro mates = new Libro("owghuiorwghb", "matematicas");
		Libro lengua = new Libro("weibikr","lengua");
		
		Recogida recogida1 = new Recogida();
		
		Asignatura mates2 = new Asignatura("Mates","2Bachiller");
		Asignatura lengua1 = new Asignatura("Lengua","2Bachiller");
		
		GenericDAO<Alumno> aDAO = new GenericDAO<Alumno>(Alumno.class);
		GenericDAO<Admin> xDAO = new GenericDAO<Admin>(Admin.class);
		GenericDAO<Libro> bDAO = new GenericDAO<Libro>(Libro.class);
		GenericDAO<Recogida> cDAO = new GenericDAO<Recogida>(Recogida.class);
		GenericDAO<Asignatura> dDao = new GenericDAO<Asignatura>(Asignatura.class);		
		
		mates2.getLibros().add(mates);
		mates.setAsignatura(mates2);
		
		lengua1.getLibros().add(lengua);
		lengua.setAsignatura(lengua1);
		
		recogida1.getId().setFecha(LocalDateTime.now());
		
		javi.getRecogidas().add(recogida1);
		recogida1.setAlumno(javi);
		
		mates.getRecogidas().add(recogida1);
		recogida1.setLibro(mates);
		
		lengua.getAdmins().add(jorjito);
		jorjito.getLibros().add(lengua);
	
		dDao.insertarRegistroHibernate(mates2);
		dDao.insertarRegistroHibernate(lengua1);
		bDAO.insertarRegistroHibernate(mates);
		bDAO.insertarRegistroHibernate(lengua);
		aDAO.insertarRegistroHibernate(javi);
		xDAO.insertarRegistroHibernate(jorjito);
		cDAO.insertarRegistroHibernate(recogida1);
	}
}
