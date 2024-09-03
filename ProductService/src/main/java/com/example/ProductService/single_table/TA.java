package com.example.ProductService.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("st_tas")
public class TA extends User{
    private int no_of_questions;
    private String college;
}
