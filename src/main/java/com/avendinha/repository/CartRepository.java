package com.avendinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avendinha.model.Cart;
import com.avendinha.model.UserModel;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(UserModel user);
}
