package com.example.ProductService.repositories;

import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find product by name
    // Select * From products Where name = {name}
    Product findByName(String name);

    // Find product by id
    // Select * From products where id = {id}
    Optional<Product> findByProductId(Long productId);

    // Find all products
    // Select * From products
    List<Product> findAll();

    // Find all products by category
    // Select * From products Where category = {category}
    Product findAllByCategory(String categoryName);

    // Delete product by Id
    //
    Product deleteByProductId(Long productId);
}
