package com.grocery_management.controller;

import com.grocery_management.model.Store;
import com.grocery_management.service.StoreService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("api/v1/stores")
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{storeId}")
    public Store getStoreById(@PathVariable Long storeId) {
        return storeService.getStoreById(storeId);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createOrUpdateStore(store);
    }

    @PutMapping("/update")
    public Store updateStore(@RequestBody Store store) {
        return storeService.createOrUpdateStore(store);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable Long storeId) {
        storeService.deleteStore(storeId);
    }

    @GetMapping("/cheapest-store")
    public Store findStoreWithCheapestProductByBarcode(@RequestParam String barcode) {
        return storeService.findStoreWithCheapestProductByBarcode(barcode);
    }

}
