package com.example.ProductService.Services;

import com.example.ProductService.Models.Product;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MySQL_DB_Impl")
public class ProductServiceImpl_WithMySQL implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long productId) {
        /*
        Take product Id from the user and call the below endpoint
         https://fakestoreapi.com/products/ + id
         */
        return productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();

        if(products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }

    @Override
    public Product createProduct(String name, String description, String category, int price) {

        /*
        Select * From products Where name = {name}
        If the above query returns a product, then do not create a new product and return the same product
         */
        Product p = productRepository.findByName(name);
        if (p != null) {
            return p;
        }

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        product = productRepository.save(product);
        System.out.println(product.getProductId());
        return product;
    }

    @Transactional
    public String updateProductById(Long productId, Product updatedProductDetails) {

        // Check if the product exist
        Product existingProduct = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        // update the product's attributes
        existingProduct.setName(updatedProductDetails.getName());
        existingProduct.setDescription(updatedProductDetails.getDescription());
        existingProduct.setCategory(updatedProductDetails.getCategory());
        existingProduct.setPrice(updatedProductDetails.getPrice());

        // Save the updated product back to the database
        productRepository.save(existingProduct);

        // Return a success message
        return "Product details updated successfully";
    }

    @Transactional
    public String deleteProductById(long productId) {
        if(!productRepository.existsById(productId)) {
            throw new ProductNotFoundException("Product not found with id: " + productId);
        }
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }

}
