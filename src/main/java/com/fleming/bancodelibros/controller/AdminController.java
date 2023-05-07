package com.fleming.bancodelibros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fleming.bancodelibros.controller.dto.AdminDto;
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
	
	@GetMapping(path = "/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdminDto>> getAdmins() {
		
		return ResponseEntity.status(HttpStatus.OK).body(adminService.getAdminsDto());
    }
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminDto> getAdmin(@RequestParam Long idAdmin) {
		
		return ResponseEntity.status(HttpStatus.OK).body(adminService.getAdminDto(idAdmin));
    }
		
	@PostMapping
	public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto) {
		
		return ResponseEntity.status(HttpStatus.OK).body(adminService.createYupdateAdmin(adminDto));
	}
	
	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAdmin(@RequestParam Long idAdmin) {
		adminService.deleteAdmin(idAdmin);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto) {

		return ResponseEntity.status(HttpStatus.OK).body(adminService.createYupdateAdmin(adminDto));
	}
}
