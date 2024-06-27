package com.avendinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avendinha.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {

}