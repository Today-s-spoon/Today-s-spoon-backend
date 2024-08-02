package com.example.todaySpoon.controller;

import com.example.todaySpoon.Service.JUserService;
import com.example.todaySpoon.entity.EatenFood;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Tag(name="분석페이지 api",description = "당일 먹은 음식을 가져오는 기능과 날짜별로 먹은 음식을 가져오는 기능이 있습니다")
@RestController
@RequestMapping("api/analysis")
public class UserController {

    @Autowired
    private JUserService jUserService;

    @Operation(summary = "당일 먹은 음식 정보 가져오기", description = "사용자가 당일 먹은 음식 정보를 조회합니다")
    @GetMapping("/{user-id}/latest") // 당일 먹은 음식 가져오기
    public List<EatenFood> getLatestFoodAnalysis(@PathVariable("user-id") String userId) {
        return jUserService.getLatestFoodByUserId(userId);
    }

    @Operation(summary = "날짜별로 먹은 음식 정보 가져오기", description = "날짜별로 먹은 음식을 저장하여 사용자가 해당 날짜에 먹은 음식을 조회할 수 있습니다")
    @GetMapping("/{user-id}/{date}") // 날짜별로 먹은 음식 가져오기
    public List<EatenFood> getFoodAnalysisByDate(@PathVariable("user-id") String userId, @PathVariable("date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return jUserService.getFoodByUserIdAndDate(userId, localDate);
    }

}
