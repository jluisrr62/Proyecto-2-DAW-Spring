package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.repos.AdminRepository;



@RequestMapping("/admins")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private final AdminRepository adminRepository = null;
	
	@GetMapping
	public List<Admin> getadmins() {
        return (List<Admin>) adminRepository.findAll();
    }
	
	@PostMapping
	public void addadmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
	}
	
	@DeleteMapping("/{id}")
	public void deleteadmin(@PathVariable("id") Integer idadmin) {
		adminRepository.deleteById(idadmin);
	}
	
	@PutMapping("/{id}")
	public void updateadmin(@PathVariable("id") Integer idadmin, @RequestBody Admin admin) {
		System.out.println("actualizado el admin " + admin.getNombre());
		
		Admin adminUpdate = adminRepository.findById(idadmin).orElseThrow();
		
		adminUpdate.setDni(admin.getDni());
		adminUpdate.setNombre(admin.getNombre());
		adminUpdate.setnUsuario(admin.getnUsuario());
		adminUpdate.setContrasenia(admin.getContrasenia());
		
		adminRepository.save(adminUpdate);
	}
}
