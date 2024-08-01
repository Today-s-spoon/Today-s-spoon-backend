package com.example.todaySpoon.Service;


import com.example.todaySpoon.Entity.EatenFood;
import com.example.todaySpoon.Entity.Food;
import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Repository.EatenFoodRepository;
import com.example.todaySpoon.Repository.FoodRepository;
import com.example.todaySpoon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EatenFoodRepository eatenFoodRepository;

    public List<EatenFood> getFoodList() {
        return eatenFoodRepository.findAll();
    }

    public EatenFood saveFood(Long foodId, String userId, float amount) {
        Optional<Food> temp = foodRepository.findById(foodId);
        Optional<User> temp2 = userRepository.findById(userId);
        if (temp.isPresent() && temp2.isPresent()) {
            Food food = temp.get();
            User user = temp2.get();
            user.setProteinAmount(user.getProteinAmount() + food.getProteinAmount()*(amount/100));
            user.setCarbohydrateAmount(user.getCarbohydrateAmount() + food.getCarbohydrateAmount()*(amount/100));
            user.setFatAmount(user.getFatAmount() + food.getFatAmount()*(amount/100));
            EatenFood eatenFood = new EatenFood(temp.get(),temp2.get(),LocalDate.now(),amount);
            return eatenFoodRepository.save(eatenFood);

        }
        else return null;


    }
/*
    public List<Food> getLatestFoodByUserId(Long userId) {
        return foodRepository.findTopByUserIdOrderByDateDesc(userId);
    }

    public List<Food> getFoodByUserIdAndDate(Long userId, LocalDate date) {
        return foodRepository.findByUserIdAndDate(userId, date);
    }
*/
//    public String fetchFoodImage(String foodName) {
//        String apiUrl = "https://api.example.com/food-image?name=" + foodName;
//        return restTemplate.getForObject(apiUrl, String.class);
//    }






}

