package com.example.todaySpoon.controller;

import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.entity.FoodDTO;
import com.example.todaySpoon.entity.User;
import com.example.todaySpoon.service.FoodService;
import com.example.todaySpoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/analysis")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/{user-id}") // 사용자 정보 분석을 위한 사용자 정보 가져오기
    public User getUserAnalysis(@PathVariable("user-id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{user-id}/latest") // 당일 먹은 음식 가져오기
    public List<FoodDTO> getLatestFoodAnalysis(@PathVariable("user-id") Long userId) {
        return foodService.getLatestFoodByUserId(userId);
    }

    @GetMapping("/{user-id}/{date}") // 날짜별로 먹은 음식 가져오기
    public List<FoodDTO> getFoodAnalysisByDate(@PathVariable("user-id") Long userId, @PathVariable("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return foodService.getFoodByUserIdAndDate(userId, localDate);
    }

}
