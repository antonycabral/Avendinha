package com.avendinha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avendinha.model.Cart;
import com.avendinha.model.Product;
import com.avendinha.model.UserModel;
import com.avendinha.repository.CartRepository;
import com.avendinha.repository.ProductRepository;
import com.avendinha.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Cria um novo carrinho para um usuário e adiciona os produtos ao carrinho
    public Cart createCart(Long userId, List<Long> productIds) {
        UserModel user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = new Cart();
        cart.setUser(user);
        cart = cartRepository.save(cart);

        // Adiciona os produtos ao carrinho
        for (Long productId : productIds) {
            addProductToCart(cart.getId(), productId, 1);
        }

        return cart;
    }

    // Adiciona um produto ao carrinho
    public Cart addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        // Verifica se há quantidade suficiente do produto disponível no estoque
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity available");
        }

        // Adiciona o produto ao carrinho e atualiza a quantidade disponível no estoque
        for (int i = 0; i < quantity; i++) {
            cart.getProducts().add(product);
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        cart.setTotal(cart.getTotal() + product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    // Remove um produto do carrinho
    public Cart removeProductFromCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        // Verifica se o produto está no carrinho antes de removê-lo
        for (int i = 0; i < quantity; i++) {
            if (!cart.getProducts().remove(product)) {
                throw new RuntimeException("Product not in cart");
            }
        }

        // Atualiza a quantidade disponível no estoque e o total do carrinho
        product.setQuantity(product.getQuantity() + quantity);
        productRepository.save(product);

        cart.setTotal(cart.getTotal() - product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    // Obtém o carrinho de compras associado a um usuário
    public Cart getCartByUserId(Long userId) {
        UserModel user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepository.findByUser(user);
    }

    // Obtém todos os carrinhos de compras no sistema
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Limpa o carrinho, removendo todos os produtos e definindo o total como zero
    public void clearCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        for (Product product : cart.getProducts()) {
            product.setQuantity(product.getQuantity() + 1);
            productRepository.save(product);
        }

        cart.getProducts().clear();
        cart.setTotal(0);
        cartRepository.save(cart);
    }

    // Obtém o total do carrinho
    public double getCartTotal(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        return cart.getTotal();
    }
}

