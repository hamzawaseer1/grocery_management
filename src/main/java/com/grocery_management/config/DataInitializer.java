//package com.grocery_management.config;
//
//import com.grocery_management.model.Product;
//import com.grocery_management.model.Store;
//import com.grocery_management.repository.ProductRepository;
//import com.grocery_management.repository.StoreRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final StoreRepository storeRepository;
//    private final ProductRepository productRepository;
//
//    public DataInitializer(StoreRepository storeRepository, ProductRepository productRepository) {
//        this.storeRepository = storeRepository;
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//        try {
//            if (storeRepository.count() < 10) {
//                for (int i = 1; i <= 10; i++) {
//                    Store store = new Store();
//                    store.setName("Store " + i);
//                    store.setLocation("Location " + i);
//                    storeRepository.save(store);
//
//                    Product product = new Product();
//                    product.setName("Product " + i);
//                    product.setBarcode("Barcode " + i);
//                    product.setDescription("Description " + i);
//                    product.setPrice(10.0 * i); // Set a price based on a pattern
//                    product.setStore(store);
//                    productRepository.save(product);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
//
