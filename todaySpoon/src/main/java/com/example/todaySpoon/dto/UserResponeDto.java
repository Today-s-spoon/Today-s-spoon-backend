package com.example.todaySpoon.dto;

import lombok.Data;

//영양소 전달할 때 사용하는 DTO
@Data
public class UserResponeDto {
    private String userName;
    private double proteinAmount;
    private double totalProteinAmount;
    private double fatAmount;
    private double totalFatAmount;
    private double carbohydrateAmount;
    private double totalCarbohydrateAmount;
}
