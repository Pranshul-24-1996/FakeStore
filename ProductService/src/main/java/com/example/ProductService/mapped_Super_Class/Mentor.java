package com.example.ProductService.mapped_Super_Class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_mentors")
public class Mentor extends User {
    private double avg_rating;
    private String current_company;
}
