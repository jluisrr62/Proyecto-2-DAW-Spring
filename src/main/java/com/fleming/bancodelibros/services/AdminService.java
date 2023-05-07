package com.fleming.bancodelibros.services;

import java.util.List;

import com.fleming.bancodelibros.modelo.Admin;

public interface AdminService {
	public Admin createAdmin(Admin admin);
	public Admin getAdmin(Integer id);
	public List<Admin> getAdmins();
	public Admin updateAdmin(Integer id, Admin admin);
	public void deleteAdmin(Integer id);
	
	public void generarAdmins();
}
