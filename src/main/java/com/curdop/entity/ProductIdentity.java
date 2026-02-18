package com.curdop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products_identity")
public class ProductIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private double price;

    public ProductIdentity() {}
    public ProductIdentity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ProductIdentity{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
