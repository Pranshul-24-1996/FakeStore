package com.example.ProductService.mapped_Super_Class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_learners")
public class Learner extends User {
    private String college;
    private String company;
}
