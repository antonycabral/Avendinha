package com.avendinha.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avendinha.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}