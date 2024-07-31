package com.example.todaySpoon.auth.dto;

import com.example.todaySpoon.auth.entity.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    public Member toEntity(String encodedPassword) {

        return Member.builder()
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