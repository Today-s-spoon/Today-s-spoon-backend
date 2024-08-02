package com.example.todaySpoon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements UserDetails {
    @Id
    @Column(name = "id",updatable = false, unique = true, nullable = false)
    private String id;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 20)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
