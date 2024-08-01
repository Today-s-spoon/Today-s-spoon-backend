package com.example.todaySpoon.Repository;


import com.example.todaySpoon.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String userId);
    @Override
    <S extends User> S save(S entity);
}
