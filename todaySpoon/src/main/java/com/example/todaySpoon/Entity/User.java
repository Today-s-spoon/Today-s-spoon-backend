package com.example.todaySpoon.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    String userID;
    String userName;
    String password;
    String gender;
    int age;
    double height;
    double weight;
    String email;
    double proteinAmount;
    double fatAmount;
    double carbohydrateAmount;
    double calorie;

    public User(){
        double BMR;
        if (gender.equals("male")){
            BMR= 88.362 + (13.397* weight) + (4.799* height) - (5.677 * age);
        }
        else {
            BMR= 447.593 + (9.247 * weight) + (3.098 * height) - (4.330* age);
        }

        calorie= BMR *  1.375;

        proteinAmount= 2.2 * weight ;
        carbohydrateAmount= calorie * 0.5 /4;
        fatAmount= calorie * 0.2 / 9;

    }

}
