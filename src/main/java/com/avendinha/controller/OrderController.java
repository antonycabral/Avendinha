package com.avendinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.avendinha.model.Order;
import com.avendinha.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint para exibir todos os pedidos
    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders"; // Retorna o template orders.html
    }

    // Endpoint para criar um novo pedido
    @PostMapping("/{userId}/create")
    public String createOrder(
            @PathVariable Long userId,
            @RequestParam String deliveryMethod,
            @RequestParam(required = false) String deliveryAddress,
            Model model) {
        Order order = orderService.createOrder(userId, deliveryMethod, deliveryAddress);
        model.addAttribute("order", order);
        return "order_confirmation"; // Retorna o template order_confirmation.html
    }
}


