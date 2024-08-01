package com.example.todaySpoon.auth.dto;

import com.example.todaySpoon.auth.entity.Member;
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
    private float height;
    private float weight;
    private String email;
    private String gender;

    static public MemberDto toDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .age(member.getAge())
                .height(member.getHeight())
                .weight(member.getWeight())
                .email(member.getEmail())
                .gender(member.getGender()).build();
    }

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .username(username)
                .age(age)
                .height(height)
                .weight(weight)
                .email(email)
                .gender(gender).build();
    }
}

