package com.example.todaySpoon.controller;

import com.example.todaySpoon.entity.EatenFood;
import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.repository.FoodRepository;
import com.example.todaySpoon.service.FoodService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class FoodController {


    private final FoodRepository foodRepository;
    private static final String CSV_FILE_PATH = "G:\\food2.csv";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/todaySpoon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0126";


    private final FoodService foodService;

    @GetMapping("/foods")
    public List<EatenFood> getFoodList() {
        return foodService.getFoodList();
    }

    @PostMapping("/{amount}/{userId}/{foodId}")
    public EatenFood addFood(@PathVariable Long foodId, @PathVariable String userId, @PathVariable float amount){
        return foodService.saveFood(foodId,userId,amount);
    }


    @GetMapping("/image/{foodName}")
    public String fetchFoodImage(@PathVariable String foodName) {
        return foodService.fetchFoodImage(foodName);
    }

    @GetMapping("/aaaa")
    public void addfood() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH))) {

            String[] nextLine;
            String insertQuery = "INSERT INTO food (foodid, food_name, unit_amount, carbohydrate_amount,fat_amount, protein_amount, calorie) VALUES (?, ?, ?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            csvReader.readNext();

            while ((nextLine = csvReader.readNext()) != null) {
                Food food = new Food();
                food.setFoodName(nextLine[0]);
                System.out.println(food.getFoodName());
                food.setProteinAmount(Float.parseFloat(nextLine[1]));
                food.setFatAmount(Float.parseFloat(nextLine[2]));
                food.setCarbohydrateAmount(Float.parseFloat(nextLine[3]));
                food.setCalorie(Float.parseFloat(nextLine[4]));
                food.setUnitAmount(Float.parseFloat(nextLine[5]));

                foodRepository.save(food);
            }


        } catch (SQLException | CsvValidationException | IOException e) {
            e.printStackTrace();
        }
    }


    }
