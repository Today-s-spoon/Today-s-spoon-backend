package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Service.JUserService;
import com.example.todaySpoon.Entity.EatenFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/analysis")
public class UserController {

    @Autowired
    private JUserService jUserService;


    @GetMapping("/{user-id}/latest") // 당일 먹은 음식 가져오기
    public List<EatenFood> getLatestFoodAnalysis(@PathVariable("user-id") String userId) {
        return jUserService.getLatestFoodByUserId(userId);
    }

    @GetMapping("/{user-id}/{date}") // 날짜별로 먹은 음식 가져오기
    public List<EatenFood> getFoodAnalysisByDate(@PathVariable("user-id") String userId, @PathVariable("date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return jUserService.getFoodByUserIdAndDate(userId, localDate);
    }

}
