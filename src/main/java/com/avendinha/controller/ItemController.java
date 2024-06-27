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
@RequestMapping("/v1/item")

public class ItemController {
        
        @PostMapping()
        public String createItem(){
            return "Create Item";
        }
    
        @GetMapping()
        public String Item(){
            return "Item deleted"; 
        }
    
        @DeleteMapping()
        public String deleteItem(){
            return "deleteItem";
        }
    
        @PutMapping()
        public String updateItem(){
            return "updateItem";
    
        }
}

