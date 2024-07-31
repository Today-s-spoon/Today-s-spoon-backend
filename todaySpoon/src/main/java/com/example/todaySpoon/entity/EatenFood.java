package com.example.todaySpoon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class EatenFood implements Serializable {
    public EatenFood(Food food, User user, LocalDate date, float eatenAmount) {
        this.userID = user.getUserId();
        this.foodId = food.getFoodId();
        this.date = date;
        this.eatenAmount = eatenAmount;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EatenFoodID;

    private String userID;

    private Long foodId;

    private LocalDate date;

    float eatenAmount;

    public EatenFood() {

    }
}