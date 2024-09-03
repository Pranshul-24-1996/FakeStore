package com.example.ProductService.single_table;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="st_userTable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;
}
