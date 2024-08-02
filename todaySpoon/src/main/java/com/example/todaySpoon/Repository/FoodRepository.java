package com.example.todaySpoon.repository;


import com.example.todaySpoon.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Override
    List<Food> findAll();
}
