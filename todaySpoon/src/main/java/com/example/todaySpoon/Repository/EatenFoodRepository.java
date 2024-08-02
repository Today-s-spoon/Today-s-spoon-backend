package com.example.todaySpoon.repository;


import com.example.todaySpoon.entity.EatenFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EatenFoodRepository extends JpaRepository<EatenFood, Long> {
    @Query("select E from EatenFood E where E.date = :date AND E.userID = :userId")
    List<EatenFood> findByUserIdAndDate(String userId, LocalDate date);

    @Query("select E from EatenFood  E where E.userID = : userId")
    List<EatenFood> findByUserId(String userId);
}
