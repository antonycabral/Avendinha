package com.avendinha.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/market")
public class MarketController {
    
    //Read//
    @GetMapping()
    public String market(){
        return "Market";
    }
    //Delete//
    @DeleteMapping()
    public String deleteMarket(){
        return "Market deleted";
    }
    //Create//
    @PostMapping()
    public String createMarket(){
        return "Market created";
    }
    //Update//
    @PutMapping()
    public String updateMarket(){
        return "Market updated";
    }
}
