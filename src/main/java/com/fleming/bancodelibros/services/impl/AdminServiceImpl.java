package com.fleming.bancodelibros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.controller.dto.AdminDto;
import com.fleming.bancodelibros.mapper.MapperService;
import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.repos.AdminRepository;
import com.fleming.bancodelibros.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private MapperService mapper;

	@Override
	public AdminDto createYupdateAdmin(AdminDto adminDto) {
		
		Admin admin = mapper.dtoToAdmin(adminDto);
		
		
		return mapper.adminToDto(adminRepo.save(admin));
	}

	@Override
	public Admin getAdmin(Long id) {
		
		return adminRepo.findById(id).get();
	}

	@Override 
	public AdminDto getAdminDto(Long id) {
		
		return mapper.adminToDto(getAdmin(id));
	}
	
	@Override
	public List<Admin> getAdmins() {
		
		return adminRepo.findAll();
	}
	
	@Override
	public List<AdminDto> getAdminsDto() {
		
		return mapper.adminsToDtos(getAdmins());
	}


	@Override
	public void deleteAdmin(Long id) {
		
		adminRepo.deleteById(id);
	}

	@Override
	public void generarAdmins() {
		
		Admin a1 = new Admin("717564691B", "Javier","6411684","jhifoew", "rgowv");
		Admin a2 = new Admin("717564623D", "Jorge","641163244","rgrgw", "rgorgwv");
		
		adminRepo.save(a1);
		adminRepo.save(a2);
	}

	@Override
	public Admin getAdminByNumeroColegiado(String nColegiado) {
		
		
		return adminRepo.findByNumeroColegiado(nColegiado);
	}
}
