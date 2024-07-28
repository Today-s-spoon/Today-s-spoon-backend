package com.example.todaySpoon.controller;

import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public List<Food> getFoodList() {
        return foodService.getFoodList();
    }

    @PostMapping("/foods")
    public Food addFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }


    @GetMapping("/image/{foodName}")
    public String fetchFoodImage(@PathVariable String foodName) {
        return foodService.fetchFoodImage(foodName);
    }
}
