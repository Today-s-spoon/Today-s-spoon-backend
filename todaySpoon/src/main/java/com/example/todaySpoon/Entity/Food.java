package com.example.todaySpoon.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long foodID;
    String foodName;
    float calorie;
    float unitAmount;
    String image;
    float proteinAmount;
    float fatAmount;
    float carbohydrateAmount;


}
