package com.grocery_management.controller;

import com.grocery_management.model.Product;
import com.grocery_management.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllStores() {
        log.info("request received for getting all products inside controller");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{productId}")
    public Product getStoreById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product createStore(@RequestBody Product product) {
        return productService.createOrUpdateProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateStore(@RequestBody Product product) {
        return productService.createOrUpdateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteStore(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
