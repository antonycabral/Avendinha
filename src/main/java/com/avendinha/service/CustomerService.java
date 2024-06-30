package com.avendinha.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avendinha.DTO.CustomerDTO;
import com.avendinha.model.Customer;
import com.avendinha.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream().map(customer -> convertToDTO(customer)).collect(Collectors.toList());
        return customerDTOs;
    }

    @Transactional(readOnly = true)
    public Optional<CustomerDTO> getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            CustomerDTO customerDTO = convertToDTO(customerOptional.get());
            return Optional.of(customerDTO);
        }
        return Optional.empty();
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerCreateDTO) {
        // Verifica se o CPF já está cadastrado
        if (customerRepository.existsByCpf(customerCreateDTO.getCpf())) {
            throw new IllegalArgumentException("CPF já está cadastrado. Por favor, recupere sua senha se esqueceu.");
        }
        // Verifica se o e-mail já está cadastrado
        if (customerRepository.existsByEmail(customerCreateDTO.getEmail())) {
            throw new IllegalArgumentException("Email já está cadastrado. Por favor, recupere sua senha se esqueceu.");
        }

        Customer customer = new Customer();
        customer.setName(customerCreateDTO.getName());
        customer.setEmail(customerCreateDTO.getEmail());
        customer.setPassword(customerCreateDTO.getPassword());
        customer.setCpf(customerCreateDTO.getCpf());

        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO customerDTO = convertToDTO(savedCustomer);
        return customerDTO;
    }

    @Transactional
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(customerDTO.getName());
            existingCustomer.setEmail(customerDTO.getEmail());
            existingCustomer.setPassword(customerDTO.getPassword());
            existingCustomer.setCpf(customerDTO.getCpf());

            Customer updatedCustomer = customerRepository.save(existingCustomer);
            CustomerDTO updatedCustomerDTO = convertToDTO(updatedCustomer);
            return updatedCustomerDTO;
        } else {
            throw new IllegalArgumentException("Cliente não encontrado por ID: " + id);
        }
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setCpf(customer.getCpf());
        return customerDTO;
    }
}
