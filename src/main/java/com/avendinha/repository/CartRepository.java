package com.avendinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avendinha.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}