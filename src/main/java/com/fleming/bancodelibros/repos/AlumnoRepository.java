package com.fleming.bancodelibros.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleming.bancodelibros.modelo.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
}
