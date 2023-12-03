package com.grocery_management.controller;

import com.grocery_management.model.Product;
import com.grocery_management.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllStores() {
        log.info("request received for getting all products inside controller");
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
