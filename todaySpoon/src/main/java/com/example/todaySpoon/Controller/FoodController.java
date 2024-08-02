package com.example.todaySpoon.Controller;

import com.example.todaySpoon.S3.S3Uploader;
import com.example.todaySpoon.Service.FoodService;
import com.example.todaySpoon.entity.EatenFood;
import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.repository.FoodRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class FoodController {


    private final FoodRepository foodRepository;
//    private static final String CSV_FILE_PATH = "G:\\food2.csv";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/todaySpoon";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "0126";

    private final S3Uploader s3Uploader;

    private final FoodService foodService;


    // 음식 리스트 다 보여주기
    @GetMapping("/foods")
    public List<Food> getFoodList() {
        return foodService.getFoodList();
    }

    // 음식 기록하기
    @PostMapping("/{amount}/{userId}/{foodId}")
    public EatenFood addFood(@PathVariable Long foodId, @PathVariable String userId, @PathVariable float amount){
        return foodService.saveFood(foodId,userId,amount);
    }

//    // 이미지 불러오기 파일명으로 url을 찾아오는 형식.
//    @GetMapping("/image")
//    public ResponseEntity<String> getFileUrl(@RequestParam("fileName") String fileName) {
//        try {
//            String fileUrl = s3Uploader.getFileUrl(fileName);
//            return ResponseEntity.ok(fileUrl);
//        } catch (S3Uploader.Exception400 e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (S3Uploader.Exception500 e) {
//            return ResponseEntity.status(500).body(e.getMessage());
//        }
//    }


//    @GetMapping("/aaaa")
//    public void addfood() {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
//
//            String[] nextLine;
//            String insertQuery = "INSERT INTO food (foodid, food_name, unit_amount, carbohydrate_amount,fat_amount, protein_amount, calorie) VALUES (?, ?, ?,?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//
//            csvReader.readNext();
//
//            while ((nextLine = csvReader.readNext()) != null) {
//                Food food = new Food();
//                food.setFoodName(nextLine[0]);
//                System.out.println(food.getFoodName());
//                food.setProteinAmount(Float.parseFloat(nextLine[1]));
//                food.setFatAmount(Float.parseFloat(nextLine[2]));
//                food.setCarbohydrateAmount(Float.parseFloat(nextLine[3]));
//                food.setCalorie(Float.parseFloat(nextLine[4]));
//                food.setUnitAmount(Float.parseFloat(nextLine[5]));
//
//                foodRepository.save(food);
//            }
//
//
//        } catch (SQLException | CsvValidationException | IOException e) {
//            e.printStackTrace();
//        }
//    }


    }
