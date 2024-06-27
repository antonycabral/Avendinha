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
@RequestMapping("/v1/Order")
 
public class OrderController {

    @PostMapping()
    public String createOrder(){
        return "Order created";
    }

    @GetMapping()
    public String order(){
        return "Order";
    }

    @PutMapping()
    public String updateOrder(){
        return "Order updated";
    }

    @DeleteMapping()
    public String deleteOrder(){
        return "Order deleted";
    }
}