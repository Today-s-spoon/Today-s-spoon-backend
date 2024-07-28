package com.example.todaySpoon.service;

import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
// 외부 API 호출을 위한 설정
// RestTemplate을 사용하여 외부 API를 호출하고 데이터 가져와서 저장
@Service
public class ExternalFoodService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FoodRepository foodRepository;

    private final String FOOD_LIST_URL = "http://external-api/post/foods";
    private final String FOOD_IMAGE_URL = "http://external-api/api/food/food-image";

    public List<String> fetchFoodList() {
        return restTemplate.getForObject(FOOD_LIST_URL, List.class);
    }

    public String fetchFoodImage() {
        return restTemplate.getForObject(FOOD_IMAGE_URL, String.class);
    }

    public Food saveFood(Food food) {
        food.setImageUrl(fetchFoodImage()); // 외부 API에서 이미지 URL 가져오기
        return foodRepository.save(food);
    }
}

