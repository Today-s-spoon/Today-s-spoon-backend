package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Entity.Food;
import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendController {

    private RecommendService recommendService;

    @GetMapping("/{userID}")
    public User getUserAmount(@PathVariable String userID) {
        return recommendService.getUserAmount(userID);

    }

    @GetMapping("/{userID}/foods")
    public List<Food> getAllFoods(@PathVariable String userID){
        return recommendService.getAllFoods(userID);
    }
}
