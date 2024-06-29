package com.avendinha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avendinha.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}