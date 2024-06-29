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

    public List<Customer> createCustomer(Customer customer) throws Exception {

        boolean emailOrCpfExists = Stream.of(customer)
                .anyMatch(c -> CustomerRepository.findByEmail(c.getEmail()) != null || CustomerRepository.findByCpf(c.getCpf()) != null);
    
        if (emailOrCpfExists) {
            throw new Exception("Email ou CPF já cadastrado.");
        }
    
        return Collections.singletonList(CustomerRepository.save(customer));
    }

}
        
    