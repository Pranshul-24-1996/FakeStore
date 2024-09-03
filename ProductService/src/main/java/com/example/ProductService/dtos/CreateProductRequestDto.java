package com.example.ProductService.dtos;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    String name;
    String description;
    String category;
    int price;
}
