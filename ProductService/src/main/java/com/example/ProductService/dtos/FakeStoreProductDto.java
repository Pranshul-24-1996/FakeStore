package com.example.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    Long id;
    String title;
    Double price;
    String description;
    String category;
    String image;
}
