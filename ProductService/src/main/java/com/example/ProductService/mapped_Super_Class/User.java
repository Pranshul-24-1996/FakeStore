package com.example.ProductService.mapped_Super_Class;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;
}
