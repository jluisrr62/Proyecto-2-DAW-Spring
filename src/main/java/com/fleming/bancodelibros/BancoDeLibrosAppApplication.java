package com.fleming.bancodelibros;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fleming.bancodelibros.interfaces.AdminRepository;
import com.fleming.bancodelibros.interfaces.AlumnoRepository;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.persistencia.TablasBD;

@SpringBootApplication
public class BancoDeLibrosAppApplication {

	public static void main(String[] args) {
		TablasBD bd = new TablasBD();
		bd.crearTablas();
		
		SpringApplication.run(BancoDeLibrosAppApplication.class, args);
	}

	
	
    @Bean
    CommandLineRunner init(AlumnoRepository alumnoRepository, AdminRepository adminRepository) {
        return args -> {
        	alumnoRepository.findAll().forEach(System.out::println);
        	adminRepository.findAll().forEach(System.out::println);
        };
    }
}
