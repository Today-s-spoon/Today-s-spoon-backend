package com.example.todaySpoon.Service;

import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.dto.UserCreateDto;
import com.example.todaySpoon.dto.UserUpdateDto;
import com.example.todaySpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getUserByUsername(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        return temp.orElse(null);
    }

    public User updateUser(UserUpdateDto user) {
        Optional<User> temp= userRepository.findById(user.getUserId());
        if(temp.isPresent()){
            User newUser = temp.get();
            newUser.setUserId(user.getUserId());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }

    public User joinUser(UserCreateDto dto) {
        double BMR;
        if (dto.getGender().equals("Male")){
            BMR= 88.362 + (13.397* dto.getWeight()) + (4.799* dto.getHeight()) - (5.677 * dto.getAge());
        }
        else {
            BMR= 447.593 + (9.247 * dto.getWeight()) + (3.098 * dto.getHeight()) - (4.330* dto.getAge());
        }

        User user = getUser(dto, BMR);
        return userRepository.save(user);
    }

    private static User getUser(UserCreateDto dto, double BMR) {
        User user= new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setAge(dto.getAge());
        user.setHeight(dto.getHeight());
        user.setWeight(dto.getWeight());
        user.setGender(dto.getGender());
        user.setEmail(dto.getEmail());

        user.setCalorie(BMR *  1.375);
        user.setProteinAmount(2.2 * user.getWeight()) ;
        user.setCarbohydrateAmount(user.getCalorie() * 0.5 /4);
        user.setFatAmount(user.getCalorie() * 0.2 / 9);
        return user;
    }
}
