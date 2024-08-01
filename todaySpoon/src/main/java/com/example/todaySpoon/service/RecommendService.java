package com.example.todaySpoon.Service;


import com.example.todaySpoon.Dto.UserResponeDto;
import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.entity.User;
import com.example.todaySpoon.repository.FoodRepository;
import com.example.todaySpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecommendService {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public UserResponeDto getUserAmount(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        if (temp.isPresent()){
            User user= temp.get();
            UserResponeDto dto= new UserResponeDto();
            dto.setUserName(user.getUsername());
            dto.setFatAmount(user.getFatAmount());
            dto.setProteinAmount(user.getProteinAmount());
            dto.setCarbohydrateAmount(user.getCarbohydrateAmount());
            dto.setTotalFatAmount(user.getFatAmount());
            dto.setTotalProteinAmount(user.getProteinAmount());
            dto.setTotalCarbohydrateAmount(user.getCarbohydrateAmount());
            return dto;
        }
        return null;
    }

    public List<Food> getAllFoods(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        if(temp.isPresent()) {
            User user= temp.get();
            List<Food> foods= foodRepository.findAll();
            return foods.stream()
                    .sorted(Comparator.comparingDouble(food -> calculate(user, food)))
                    .limit(4)
                    .toList();
        }
        return null;
    }

    private double calculate(User user, Food food){
        double carbDiff =  Math.max(user.getTotalCarbohydrateAmount()-user.getCarbohydrateAmount(),0) - food.getCarbohydrateAmount();
        double proteinDiff = Math.max(user.getTotalProteinAmount()-user.getProteinAmount(),0) - food.getProteinAmount();
        double fatDiff = Math.max(user.getTotalFatAmount()-user.getFatAmount(),2)- food.getFatAmount();
        return Math.pow(carbDiff,2) + Math.pow(proteinDiff,2) + Math.pow(fatDiff,2);
    }

}
