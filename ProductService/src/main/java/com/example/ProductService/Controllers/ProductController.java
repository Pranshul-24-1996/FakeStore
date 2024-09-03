package com.example.ProductService.Controllers;

import com.example.ProductService.Models.Product;
import com.example.ProductService.Services.ProductService;
import com.example.ProductService.dtos.CreateProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("MySQL_DB_Impl")
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
        //Basic check
        if(productId < 1 || productId > 20) {
            return new ResponseEntity<Product>(HttpStatusCode.valueOf(400));
        }
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getProducts();

        // Basic Check 1: Ensure the list is not null
        if(products == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        // Basic Check 2: Check if the list is empty
        if(products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto) throws Exception {
        System.out.println(requestDto);

        //Basic Validation
        if(requestDto.getName() == null || requestDto.getName().isEmpty()) {
            throw new Exception();
        }
        return productService.createProduct(requestDto.getName(), requestDto.getDescription(),
                                            requestDto.getCategory(), requestDto.getPrice());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProductById(@PathVariable("productId") long productId, @RequestBody Product updatedProductDetails) {
        // Basic validation
        if(updatedProductDetails == null) {
            throw new IllegalArgumentException("Product Id cannot be null");
        }

        /* This validation is not working
        if (updatedProductDetails.getProductId() == null) {
            throw new IllegalArgumentException("Product ID in request body cannot be null");
        }*/

        String message = productService.updateProductById(productId, updatedProductDetails);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") long productId) {
        String message = productService.deleteProductById(productId);
        return ResponseEntity.ok(message);
    }
}
