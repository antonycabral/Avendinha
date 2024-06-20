package com.avendinha.model;

import java.util.ArrayList;
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

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_carrinho") // Especifica o nome da tabela no banco de dados
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática de IDs
    private Long id;

    @OneToOne // Relacionamento um-para-um com a tabela de usuários
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Especifica a coluna de junção
    private UserModel user;

    @ManyToMany // Relacionamento muitos-para-muitos com a tabela de produtos
    @JoinTable(
        name = "tb_carrinho_produto", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "cart_id"), // Coluna de junção nesta entidade
        inverseJoinColumns = @JoinColumn(name = "product_id")) // Coluna de junção na outra entidade
    private List<Product> products = new ArrayList<>(); // Lista de produtos no carrinho

    @Column(name = "total") // Mapeia o campo total para a coluna "total" no banco de dados
    private double total;

    // Construtor padrão
    public Cart() {}

    // Construtor parametrizado para criar instâncias de Cart
    public Cart(Long id, UserModel user, List<Product> products, double total) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.total = total;
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
}
