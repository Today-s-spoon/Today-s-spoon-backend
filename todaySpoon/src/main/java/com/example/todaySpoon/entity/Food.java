package com.example.todaySpoon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private String foodName;
    private String image;
    private float unitAmount;
    private float carbohydrateAmount;
    private float proteinAmount;
    private float fatAmount;
    private LocalDate date;
    private Long userId;
    private float calorie;

}

