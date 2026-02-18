package com.curdop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products_sequence")
@SequenceGenerator(name = "prod_seq", sequenceName = "prod_sequence", allocationSize = 1)
public class ProductSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private double price;

    public ProductSequence() {}
    public ProductSequence(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ProductSequence{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
