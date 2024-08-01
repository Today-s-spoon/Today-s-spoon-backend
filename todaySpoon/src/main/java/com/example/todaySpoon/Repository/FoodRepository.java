package com.example.todaySpoon.Repository;


import com.example.todaySpoon.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Override
    List<Food> findAll();
}
