package com.example.todaySpoon.yerin.Entity;

import jakarta.persistence.Entity;
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
    private double totalProteinAmount;
    private double fatAmount;
    private double totalFatAmount;
    private double carbohydrateAmount;
    private double totalCarbohydrateAmount;
    private double calorie;

}
