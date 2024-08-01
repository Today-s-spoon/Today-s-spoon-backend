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
    private float height;
    private float weight;
    private String email;
    private String gender;

    public User toEntity(String encodedPassword) {

        return User.builder()
                .id(id)
                .password(encodedPassword)
                .username(username)
                .age(age)
                .height(height)
                .weight(weight)
                .email(email)
                .gender(gender)
                .build();
    }
}