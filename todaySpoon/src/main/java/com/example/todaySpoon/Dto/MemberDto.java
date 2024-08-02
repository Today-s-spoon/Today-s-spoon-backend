package com.example.todaySpoon.Dto;


import com.example.todaySpoon.entity.User;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String id;
    private String username;
    private int age;
    private double height;
    private double weight;
    private String email;
    private String gender;

    static public MemberDto toDto(User user) {
        return MemberDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .height(user.getHeight())
                .weight(user.getWeight())
                .email(user.getEmail())
                .gender(user.getGender()).build();
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .username(username)
                .age(age)
                .height(height)
                .weight(weight)
                .email(email)
                .gender(gender).build();
    }
}

