package com.avendinha.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_pedidos") // Especifica o nome da tabela no banco de dados
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática de IDs
    private Long id;

    @OneToOne // Relacionamento um-para-um com a tabela de usuários
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Especifica a coluna de junção
    private UserModel user;

    @ManyToMany // Relacionamento muitos-para-muitos com a tabela de produtos
    @JoinTable(
        name = "tb_pedido_produto", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "order_id"), // Coluna de junção nesta entidade
        inverseJoinColumns = @JoinColumn(name = "product_id")) // Coluna de junção na outra entidade
    private List<Product> products = new ArrayList<>(); // Lista de produtos no pedido

    @Column(name = "total") // Mapeia o campo total para a coluna "total" no banco de dados
    private double total;

    @Column(name = "delivery_method") // Mapeia o método de entrega para a coluna "delivery_method"
    private String deliveryMethod;

    @Column(name = "delivery_address") // Mapeia o endereço de entrega para a coluna "delivery_address"
    private String deliveryAddress;

    // Construtor padrão
    public Order() {}

    // Construtor parametrizado para criar instâncias de Order
    public Order(UserModel user, List<Product> products, double total, String deliveryMethod, String deliveryAddress) {
        this.user = user;
        this.products = products;
        this.total = total;
        this.deliveryMethod = deliveryMethod;
        this.deliveryAddress = deliveryAddress;
    }

    // Métodos getters e setters para acessar e modificar os campos da entidade
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
