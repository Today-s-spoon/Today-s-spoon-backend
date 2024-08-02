package com.example.todaySpoon.repository;


import com.example.todaySpoon.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String userId);
    @Override
    <S extends User> S save(S entity);
}
