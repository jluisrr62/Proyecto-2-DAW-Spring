package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.fleming.bancodelibros.services.AdminService;



@RequestMapping("/admins")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/generar")
	public void generarAdmins() {
		adminService.generarAdmins();
	}
	
	@GetMapping
	public ResponseEntity<List<Admin>> getAdmins() {
		
		List<Admin> admins = adminService.getAdmins();
		
		if(admins == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(admins);
		}
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") Integer idAdmin) {
		
		Admin admin = adminService.getAdmin(idAdmin);
		
		if(admin == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(admin);
		}
    }
		
	@PostMapping
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		
		Admin adminCreated = adminService.createAdmin(admin);;
		
		if(admin == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(adminCreated);
		}
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable("id") Integer idAdmin) {
		adminService.deleteAdmin(idAdmin);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer idAdmin, @RequestBody Admin admin) {
		Admin adminUpdated = adminService.updateAdmin(idAdmin, admin);
		
		if(adminUpdated == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(adminUpdated);
		}
	}
}
