package com.example.todaySpoon.repository;

import com.example.todaySpoon.entity.Food;
import com.example.todaySpoon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
