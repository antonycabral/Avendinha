package com.avendinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.avendinha.model.Cart;
import com.avendinha.service.CartService;


@Controller
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // Endpoint para exibir o carrinho de um usuário
    @GetMapping("/{userId}")
    public String getCartByUserId(@PathVariable Long userId, Model model) {
        Cart cart = cartService.getCartByUserId(userId);
        model.addAttribute("cart", cart);
        return "cart"; // Retorna o template cart.html
    }

    // Endpoint para adicionar um produto ao carrinho
    @PostMapping("/{userId}/add")
    public String addProductToCart(
            @PathVariable Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity,
            Model model) {
        Cart cart = cartService.addProductToCart(userId, productId, quantity);
        model.addAttribute("cart", cart);
        return "cart"; // Retorna o template cart.html
    }

    // Endpoint para remover um produto do carrinho
    @PostMapping("/{userId}/remove")
    public String removeProductFromCart(
            @PathVariable Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity,
            Model model) {
        Cart cart = cartService.removeProductFromCart(userId, productId, quantity);
        model.addAttribute("cart", cart);
        return "cart"; // Retorna o template cart.html
    }
}