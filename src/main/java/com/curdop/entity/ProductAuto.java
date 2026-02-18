package com.curdop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products_auto")
public class ProductAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private double price;

    public ProductAuto() {}
    public ProductAuto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ProductAuto{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
