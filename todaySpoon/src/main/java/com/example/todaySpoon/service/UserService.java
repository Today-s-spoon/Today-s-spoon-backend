package com.example.todaySpoon.service;

import com.example.todaySpoon.entity.EatenFood;
import com.example.todaySpoon.repository.EatenFoodRepository;
import com.example.todaySpoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private EatenFoodRepository eatenFoodRepository;


    public List<EatenFood> getLatestFoodByUserId(String userId) {
        return getFoodByUserIdAndDate(userId, LocalDate.now());
    }

    public List<EatenFood> getFoodByUserIdAndDate(String userId, LocalDate date) {
        return eatenFoodRepository.findByUserIdAndDate(userId, date);
    }

}
