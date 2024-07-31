package com.example.todaySpoon.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String userId;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private String email;
}
