package com.avendinha.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "cart_item",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    @ElementCollection
    @CollectionTable(name = "item_quantities", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> quantities = new HashMap<>();


    private double totoalPrice;

    public Cart() {
    }

    public Cart(Long id, Customer customer, List<Item> items, Map<Item, Integer> quantities, double totoalPrice) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.quantities = quantities;
        this.totoalPrice = totoalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<Item, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Item, Integer> quantities) {
        this.quantities = quantities;
    }

    public double getTotoalPrice() {
        return totoalPrice;
    }

    public void setTotoalPrice(double totoalPrice) {
        this.totoalPrice = totoalPrice;
    }

    
}
