package com.avendinha.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin (origins="*")
@RequestMapping("/v1/cart")
public class CartController {
    
    @PostMapping()
    public String createCart(){
        return "Cart created";
    }

    @GetMapping()
    public String cart(){
        return "Cart get";
    }

    @PutMapping()
    public String updateCart(){
        return "Cart updated";
    }

    @DeleteMapping()
    public String deleteCart(){
        return "Cart delete";
}
}