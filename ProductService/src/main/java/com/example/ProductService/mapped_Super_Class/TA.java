package com.example.ProductService.mapped_Super_Class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_tas")
public class TA extends User {
    private int no_of_questions;
    private String college;
}
