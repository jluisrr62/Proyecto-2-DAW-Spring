package com.fleming.bancodelibros.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fleming.bancodelibros.modelo.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{
}
