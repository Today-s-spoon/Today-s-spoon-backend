package com.example.todaySpoon.Service;


import com.example.todaySpoon.Entity.EatenFood;
import com.example.todaySpoon.Repository.EatenFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JUserService {

    @Autowired
    private EatenFoodRepository eatenFoodRepository;


    public List<EatenFood> getLatestFoodByUserId(String userId) {
        return getFoodByUserIdAndDate(userId, LocalDate.now());
    }

    public List<EatenFood> getFoodByUserIdAndDate(String userId, LocalDate date) {
        return eatenFoodRepository.findByUserIdAndDate(userId, date);
    }

}
