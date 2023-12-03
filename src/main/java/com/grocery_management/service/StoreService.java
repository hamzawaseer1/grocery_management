package com.grocery_management.service;

import com.grocery_management.exception.StoreNotFoundException;
import com.grocery_management.model.Product;
import com.grocery_management.model.Store;
import com.grocery_management.repository.ProductRepository;
import com.grocery_management.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StoreService {


    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public StoreService(StoreRepository storeRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAllOrderedByDescending();
    }

    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }

    public Store createOrUpdateStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    public Store findStoreWithCheapestProductByBarcode(String barcode) {
        return productRepository.findAllByBarcode(barcode)
                .stream()
                .min(Comparator.comparing(Product::getPrice))
                .map(Product::getStore)
                .get();
    }
}
