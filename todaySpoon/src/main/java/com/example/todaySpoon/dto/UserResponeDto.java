package com.example.todaySpoon.dto;

import lombok.Data;

@Data
public class UserResponeDto {
    private String userName;
    private double proteinAmount;
    private double fatAmount;
    private double carbohydrateAmount;
}
