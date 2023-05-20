package com.fleming.bancodelibros.services;

import com.fleming.bancodelibros.modelo.Libro;

public interface LibroService {

	Libro getLibroByIsbn(String isbn);

}
