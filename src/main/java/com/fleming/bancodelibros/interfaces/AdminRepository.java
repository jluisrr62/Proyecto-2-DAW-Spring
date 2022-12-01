package com.fleming.bancodelibros.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.fleming.bancodelibros.modelo.Admin;

public interface AdminRepository extends CrudRepository<Admin, String>{
}
