package com.fleming.bancodelibros.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fleming.bancodelibros.modelo.Deposito;
import com.fleming.bancodelibros.modelo.DepositoId;

public interface DepositoRepository extends JpaRepository<Deposito, DepositoId>{

}
