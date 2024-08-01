package com.example.todaySpoon.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private String userId;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private String email;
    private double proteinAmount;
    private double fatAmount;
    private double carbohydrateAmount;
    private double calorie;
}

