package com.fleming.bancodelibros.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleming.bancodelibros.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
