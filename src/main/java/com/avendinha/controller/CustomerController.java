package com.avendinha.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/customer")
public class CustomerController {

@PostMapping()
public String createCustomer(){
    return "Create Customer";
}

@GetMapping()
public String Customer(){
    return "Customer deleted"; 
}

@PutMapping()
public String updateCustomer(){
    return "updateCustomer";
}

@DeleteMapping()
public String deleteCustomer(){
    return "deleteCustomer";
}
}