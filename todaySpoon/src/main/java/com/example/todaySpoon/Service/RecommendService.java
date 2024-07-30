package com.example.todaySpoon.Service;

import com.example.todaySpoon.Entity.Food;
import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.dto.UserResponeDto;
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
            dto.setUserName(user.getUserName());
            dto.setFatAmount(user.getFatAmount());
            dto.setProteinAmount(user.getProteinAmount());
            dto.setCarbohydrateAmount(user.getCarbohydrateAmount());
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
        double carbDiff =  user.getCarbohydrateAmount() - food.getCarbohydrateAmount();
        double proteinDiff = user.getProteinAmount() - food.getProteinAmount();
        double fatDiff = user.getFatAmount()- food.getFatAmount();
        return Math.pow(carbDiff,2) + Math.pow(proteinDiff,2) + Math.pow(fatDiff,2);
    }

}
