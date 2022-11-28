package com.fleming.bancodelibros;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    CommandLineRunner init(AlumnoRepository alumnoRepository) {
        return args -> {
        	
    		Alumno luis = new Alumno("734345D","Luis", "patukos", "6573");
        	
        	alumnoRepository.save(luis);
        	alumnoRepository.findAll().forEach(System.out::println);
        };
    }
}
