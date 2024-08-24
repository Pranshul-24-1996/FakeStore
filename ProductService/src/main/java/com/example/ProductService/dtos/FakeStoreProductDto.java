package com.example.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    long id;
    String title;
    int price;
    String description;
    String category;
    String image;
}
