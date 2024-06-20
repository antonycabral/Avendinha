package com.avendinha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avendinha.model.Cart;
import com.avendinha.model.Order;
import com.avendinha.model.UserModel;
import com.avendinha.repository.CartRepository;
import com.avendinha.repository.OrderRepository;
import com.avendinha.repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    // Cria um novo pedido com base no carrinho do usuário
    public Order createOrder(Long userId, String deliveryMethod, String deliveryAddress) {
        UserModel user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Obtém o carrinho associado ao usuário
        Cart cart = cartRepository.findByUser(user);

        // Verifica se o carrinho existe
        if (cart == null) {
            throw new RuntimeException("Cart not found for user");
        }

        // Cria um novo pedido com base no carrinho do usuário
        Order order = new Order();
        order.setUser(user);
        order.setProducts(cart.getProducts());
        order.setTotal(cart.getTotal());
        order.setDeliveryMethod(deliveryMethod);

        // Define o endereço de entrega ou "Retirada na loja" se o método de entrega for diferente de "delivery"
        if ("delivery".equalsIgnoreCase(deliveryMethod)) {
            order.setDeliveryAddress(deliveryAddress);
        } else {
            order.setDeliveryAddress("Pickup at store");
        }

        // Limpa o carrinho após a criação do pedido
        cart.getProducts().clear();
        cart.setTotal(0);
        cartRepository.save(cart);

        // Salva o pedido no banco de dados
        return orderRepository.save(order);
    }

    // Obtém todos os pedidos no sistema
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obtém um pedido pelo ID
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getOrdersByUserId(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrdersByUserId'");
    }
}