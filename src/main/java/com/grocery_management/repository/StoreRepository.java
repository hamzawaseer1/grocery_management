package com.grocery_management.repository;

import com.grocery_management.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

//    @Query("SELECT s FROM Store s " +
//            "JOIN s.products p " +
//            "WHERE p.barcode = :barcode " +
//            "AND p.price = (SELECT MIN(p2.price) FROM Product p2 WHERE p2.barcode = :barcode)")
//    Store findStoreWithCheapestProductByBarcode(@Param("barcode") String barcode);

    @Query(value = "SELECT * FROM store ORDER BY id DESC", nativeQuery = true)
    List<Store> findAllOrderedByDescending();
}
