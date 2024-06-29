package com.avendinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avendinha.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByEmail(String email);
    Customer findByCpf(String cpf);
}