package com.grocery_management.repository;

import com.grocery_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBarcode(String barcode);
}
