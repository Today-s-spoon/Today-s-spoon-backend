package com.example.todaySpoon.service;

import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.entity.FoodDTO;
import com.example.todaySpoon.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestTemplate restTemplate;
    public List<Food> getFoodList() {
        return foodRepository.findAll();
    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
/*
    public List<Food> getLatestFoodByUserId(Long userId) {
        return foodRepository.findTopByUserIdOrderByDateDesc(userId);
    }

    public List<Food> getFoodByUserIdAndDate(Long userId, LocalDate date) {
        return foodRepository.findByUserIdAndDate(userId, date);
    }
*/
    public String fetchFoodImage(String foodName) {
        String apiUrl = "https://api.example.com/food-image?name=" + foodName;
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public List<FoodDTO> getLatestFoodByUserId(Long userId) {
        List<Food> foods = foodRepository.findTopByUserIdOrderByDateDesc(userId);
        return foods.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<FoodDTO> getFoodByUserIdAndDate(Long userId, LocalDate date) {
        List<Food> foods = foodRepository.findByUserIdAndDate(userId, date);
        return foods.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private FoodDTO convertToDTO(Food food) {
        FoodDTO dto = new FoodDTO();
        dto.setId(food.getId());
        dto.setCarbohydrates(food.getCarbohydrates());
        dto.setProtein(food.getProtein());
        dto.setFat(food.getFat());
        return dto;
    }
}

