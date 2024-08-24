package com.example.ProductService.Controllers;

import com.example.ProductService.Models.Product;
import com.example.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
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
}
