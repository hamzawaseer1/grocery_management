package com.grocery_management.repository;

import com.grocery_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBarcode(String barcode);

    @Query(value = "SELECT * FROM product ORDER BY id DESC", nativeQuery = true)
    List<Product> findAllOrderedByDescending();
}
