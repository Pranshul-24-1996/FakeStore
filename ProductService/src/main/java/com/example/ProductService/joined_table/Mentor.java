package com.example.ProductService.joined_table;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="jt_mentors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User{
    private double avg_rating;
    private String current_company;
}
