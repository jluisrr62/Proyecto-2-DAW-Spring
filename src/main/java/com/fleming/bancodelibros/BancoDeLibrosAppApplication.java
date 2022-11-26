package com.fleming.bancodelibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fleming.bancodelibros.persistencia.TablasBD;

@SpringBootApplication
public class BancoDeLibrosAppApplication {

	public static void main(String[] args) {
		TablasBD bd = new TablasBD();
		bd.crearTablas();
		
		SpringApplication.run(BancoDeLibrosAppApplication.class, args);
	}

}
