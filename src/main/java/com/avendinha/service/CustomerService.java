package com.avendinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avendinha.model.Customer;
import com.avendinha.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        // Verifica se o CPF já está cadastrado
        if (customerRepository.findAll().stream().anyMatch(c -> c.getCpf().equals(customer.getCpf()))) {
            throw new IllegalArgumentException("CPF already exists. Please recover your password if you forgot it.");
        }
        // Verifica se o e-mail já está cadastrado
        if (customerRepository.findAll().stream().anyMatch(c -> c.getEmail().equals(customer.getEmail()))) {
            throw new IllegalArgumentException("Email already exists. Please recover your password if you forgot it.");
        }
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer customer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(customer.getName());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setPassword(customer.getPassword());
                    existingCustomer.setCpf(customer.getCpf());
                    return customerRepository.save(existingCustomer);
                })
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
