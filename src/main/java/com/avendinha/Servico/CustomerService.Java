package com.avendinha.Servico;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avendinha.model.Customer;
import com.avendinha.repository.CustomerRepository;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository CustomerRepository;

    
    public List<Customer> getAllCustomers(){
        return CustomerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return CustomerRepository.findById(id).get();
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        // Verifica se o CPF já está cadastrado
        if (customerRepository.findByCpf(customer.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF already exists. Please recover your password if you forgot it.");
        }
        // Verifica se o e-mail já está cadastrado
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists. Please recover your password if you forgot it.");
        }
        return customerRepository.save(customer);
    }

}
        
    