package com.fleming.bancodelibros.repos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.modelo.DepositoId;

public interface DepositoRepository extends JpaRepository<Deposito, DepositoId>{

	List<LocalDateTime> findIdFechaByAdminId(Long adminID);

	Set<Deposito> findByAdminId(Long adminId);

	Set<Deposito> findByLibroId(Long id);

}
