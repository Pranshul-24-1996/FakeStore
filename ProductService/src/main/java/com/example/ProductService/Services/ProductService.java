package com.example.ProductService.Services;

import com.example.ProductService.Models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long productId);

    public List<Product> getProducts();

    public Product createProduct(String name, String description , String category, int price);

    public String updateProductById(Long productId, Product updatedProductDetails);

    public String deleteProductById(long productId);
}
