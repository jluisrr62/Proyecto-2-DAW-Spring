package com.fleming.bancodelibros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleming.bancodelibros.modelo.Admin;
import com.fleming.bancodelibros.repos.AdminRepository;
import com.fleming.bancodelibros.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public Admin getAdmin(Integer id) {
		// TODO Auto-generated method stub
		return adminRepo.findById(id).get();
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return (List<Admin>) adminRepo.findAll();
	}

	@Override
	public Admin updateAdmin(Integer id, Admin admin) {
		// TODO Auto-generated method stub
		
		Admin adminUpdate = adminRepo.findById(id).get();
		
		adminUpdate.setDni(admin.getDni());
		adminUpdate.setNombre(admin.getNombre());
		adminUpdate.setnUsuario(admin.getnUsuario());
		adminUpdate.setnColegiado(admin.getnColegiado());
		adminUpdate.setContrasenia(admin.getContrasenia());
		
		return adminRepo.save(adminUpdate);
	}

	@Override
	public void deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		adminRepo.deleteById(id);
	}

	@Override
	public void generarAdmins() {
		// TODO Auto-generated method stub
		Admin a1 = new Admin("717564691B", "Javier","6411684","jhifoew", "rgowv");
		Admin a2 = new Admin("717564623D", "Jorge","641163244","rgrgw", "rgorgwv");
		
		adminRepo.save(a1);
		adminRepo.save(a2);
	}

}
