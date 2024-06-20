package com.avendinha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_produto") // Especifica o nome da tabela no banco de dados
public class Product {
    @Id // Anotação para indicar a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática de IDs
    private Long id; // ID do produto

    private String name; // Nome do produto
    private String description; // Descrição do produto
    private Double price; // Preço do produto
    private int quantity; // Quantidade disponível do produto

    // Métodos getters e setters para acessar e modificar os campos da entidade

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

