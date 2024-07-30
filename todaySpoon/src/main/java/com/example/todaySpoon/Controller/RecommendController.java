package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Entity.Food;
import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Service.RecommendService;
import com.example.todaySpoon.dto.UserResponeDto;
import com.example.todaySpoon.repository.FoodRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RestController
@Tag(name="추천 API",description = "user의 영양소정보와 추선식사 리스트 조회 API")
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;
    private final FoodRepository foodRepository;
    private static final String CSV_FILE_PATH = "C:\\food.csv";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/todaySpoon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0317";

    @Operation(summary = "")
    @GetMapping("/{userID}")
    public UserResponeDto getUserAmount(@PathVariable String userID) {
        return recommendService.getUserAmount(userID);
    }

    @GetMapping("/{userID}/foods")
    public List<Food> getAllFoods(@PathVariable String userID){
        return recommendService.getAllFoods(userID);
    }


    @GetMapping("/aaaa")
    public void addfood(){

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH))) {

            String[] nextLine;
            String insertQuery = "INSERT INTO food (foodid, food_name, unit_amount, carbohydrate_amount,fat_amount, protein_amount, calorie) VALUES (?, ?, ?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            csvReader.readNext();

            while ((nextLine = csvReader.readNext()) != null) {
                Food food = new Food();
                food.setFoodName(nextLine[0]);
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
