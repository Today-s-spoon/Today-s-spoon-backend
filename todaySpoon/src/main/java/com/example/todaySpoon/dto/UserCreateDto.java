package com.example.todaySpoon.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UserCreateDto {

    private String userId;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private String email;
}
