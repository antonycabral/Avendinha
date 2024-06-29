package com.avendinha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.avendinha.model.Cart;
import com.avendinha.repository.CartRepository;
import com.avendinha.repository.CustomerRepository;
import com.avendinha.repository.ItemRepository;

public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public Optional<Cart> getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

}
