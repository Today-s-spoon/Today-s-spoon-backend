package com.example.todaySpoon.repository;

import com.example.todaySpoon.Entity.RecommendFood;
import com.example.todaySpoon.Entity.RecommendFoodID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendFoodRepository extends JpaRepository<RecommendFood, RecommendFoodID> {

}
