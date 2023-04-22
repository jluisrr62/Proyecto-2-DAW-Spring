package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.modelo.Alumno;
import com.fleming.bancodelibros.repos.AdminRepository;
import com.fleming.bancodelibros.repos.AlumnoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	

}
