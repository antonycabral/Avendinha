package com.avendinha.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "order_items",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private Double totalPrice;
    private String paymentMethod;
    private String deliveryMethod;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    public Order() {
    }

    public Order(Long id, Customer customer, List<Item> items, Double totalPrice, String paymentMethod,
            String deliveryMethod, Market market) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.market = market;
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

    /**
     * Sets the customer for this order.
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the list of items in the order.
     *
     * @return the list of items in the order
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of items for this order.
     *
     * @param items the list of items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns the total price of the order.
     *
     * @return the total price of the order
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the order.
     *
     * @param totalPrice the total price of the order
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Returns the payment method for this order.
     *
     * @return the payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method for the order.
     *
     * @param paymentMethod the payment method to be set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returns the delivery method of the order.
     *
     * @return the delivery method of the order
     */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the delivery method for the order.
     *
     * @param deliveryMethod the delivery method to be set
     */
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Returns the market associated with this order.
     *
     * @return the market associated with this order
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Sets the market for this order.
     *
     * @param market the market to set
     */
    public void setMarket(Market market) {
        this.market = market;
    }

    

}
