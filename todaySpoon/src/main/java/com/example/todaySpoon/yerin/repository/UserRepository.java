package com.example.todaySpoon.yerin.repository;

import com.example.todaySpoon.yerin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    Optional<User> findById(String s);

    @Override
    <S extends User> S save(S entity);
}
