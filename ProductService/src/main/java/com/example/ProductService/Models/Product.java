package com.example.ProductService.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    long productId;
    String name;
    int price;
    String description;
    String category;
    String image;
}
