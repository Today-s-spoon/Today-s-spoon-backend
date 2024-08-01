package com.example.todaySpoon.yerin.repository;

import com.example.todaySpoon.yerin.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Override
    List<Food> findAll();
}
