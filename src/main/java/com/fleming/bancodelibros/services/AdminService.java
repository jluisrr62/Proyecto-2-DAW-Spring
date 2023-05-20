package com.fleming.bancodelibros.services;

import java.util.List;

import com.fleming.bancodelibros.controller.dto.AdminDto;
import com.fleming.bancodelibros.modelo.Admin;

public interface AdminService {
	AdminDto createYupdateAdmin(AdminDto admin);
	Admin getAdmin(Long id);
	List<Admin> getAdmins();
	void deleteAdmin(Long id);
	
	void generarAdmins();
	AdminDto getAdminDto(Long id);
	List<AdminDto> getAdminsDto();
	Admin getAdminByNumeroColegiado(String getnColegiado);
}
