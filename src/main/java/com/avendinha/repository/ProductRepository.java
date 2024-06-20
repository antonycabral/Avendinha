package com.avendinha.repository;

import com.avendinha.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    @Modifying
    @Query("update Product p set p.name = :name, p.description = :description, p.price = :price where p.id = :id")
    void updateProduct(@Param("id") Long id, @Param("name") String name, @Param("description") String description, @Param("price") Double price);

    @Modifying
    @Query("delete from Product p where p.id = :id")
    void deleteProductById(@Param("id") Long id);
}
