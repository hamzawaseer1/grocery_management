package com.grocery_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String barcode;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
