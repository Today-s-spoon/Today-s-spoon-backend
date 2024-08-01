package com.example.todaySpoon.Dto;


import com.example.todaySpoon.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {

    private String id;
    private String password;
    private String username;
    private int age;
    private double height;
    private double weight;
    private String email;
    private String gender;
    private double proteinAmount;
    private double totalProteinAmount;
    private double fatAmount;
    private double totalFatAmount;
    private double carbohydrateAmount;
    private double totalCarbohydrateAmount;
    private double calorie;
    public User toEntity(String encodedPassword) {
        setNut();
        return User.builder()
                .id(id)
                .password(encodedPassword)
                .username(username)
                .age(age)
                .height(height)
                .weight(weight)
                .email(email)
                .gender(gender)
                .totalFatAmount(totalFatAmount)
                .totalCarbohydrateAmount(totalCarbohydrateAmount)
                .totalProteinAmount(totalProteinAmount)
                .calorie(calorie)
                .fatAmount(fatAmount)
                .carbohydrateAmount(carbohydrateAmount)
                .proteinAmount(proteinAmount)
                .build();
    }
    public void setNut(){
        double BMR;
        if (this.gender.equals("Male")){
            BMR= 88.362 + (13.397* weight) + (4.799* height) - (5.677 * age);
        }
        else {
            BMR= 447.593 + (9.247 * weight) + (3.098 * height) - (4.330* age);
        }
        this.calorie = BMR*1.375;
        this.totalCarbohydrateAmount = this.calorie*0.5/4;
        this.totalFatAmount = this.calorie*0.2/9;
        this.totalProteinAmount = this.weight*2.2;
        this.proteinAmount = 0;
        this.fatAmount = 0;
        this.carbohydrateAmount = 0;
    }
}