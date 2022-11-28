package com.fleming.bancodelibros.persistencia;

import java.util.ArrayList;
import java.util.TimeZone;

import javax.persistence.PersistenceException;


import org.hibernate.Session;
import org.hibernate.Transaction;


import com.fleming.bancodelibros.util.*;

public class GenericDAO<T>{
private Class<T> claseDelRegistro;
	
	public GenericDAO(Class<T> miClase) {
		claseDelRegistro = miClase;
	}
	
	
	//Hibernate
	public void insertarRegistroHibernate(T b) {
		Transaction tr = null;
		Session sesion = null;

		try {

			sesion = HibernateUtil.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("GMT+1")).openSession();
			tr = sesion.beginTransaction();
			sesion.persist(b);
			tr.commit();

		} catch (PersistenceException e) {
			tr.rollback();

		} finally {
			sesion.close();
		}
	}
	
	public void modificarRegsitroHibernate(T b) {
		Transaction tr = null;
		Session sesion = null;
		
		try {

			sesion = HibernateUtil.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("GMT+1")).openSession();
			tr = sesion.beginTransaction();
			sesion.merge(b);
			tr.commit();

		} catch (PersistenceException e) {
			tr.rollback();

		} finally {
			sesion.close();
		}
	}
	
	public void deleteRegistroHibernate(T b) {
		Transaction tr = null;
		Session sesion = null;
		
		try {

			sesion = HibernateUtil.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("GMT+1")).openSession();
			tr = sesion.beginTransaction();
			sesion.remove(b);
			tr.commit();

		} catch (PersistenceException e) {
			tr.rollback();

		} finally {
			sesion.close();
		}
	}
	
	public ArrayList<T> listarRegistrosHibernate(String clase) {
		ArrayList<T> resultado = null;
		
		Transaction tr = null;
		Session sesion = null;
		
		try {

			sesion = HibernateUtil.getSessionFactory().openSession();
			tr = sesion.beginTransaction();
			resultado = (ArrayList<T>) sesion.createQuery("from "+clase).getResultList();
			tr.commit();
			
			return resultado;

		} catch (PersistenceException e) {
			tr.rollback();

		} finally {
			sesion.close();
		}
		
		return null;
	}
	
	public T buscarPorIdHibernate(int i) {
		
		Transaction tr = null;
		Session sesion = null;
		
		try {

			sesion = HibernateUtil.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("GMT+1")).openSession();
			tr = sesion.beginTransaction();
			T miRegistro = sesion.find(claseDelRegistro, i);
			System.out.println("El registro buscado se llama " + miRegistro);
			tr.commit();
			return miRegistro;

		} catch (PersistenceException e) {
			tr.rollback();

		} finally {
			sesion.close();
		}
		
		return null;
	}
	
}
