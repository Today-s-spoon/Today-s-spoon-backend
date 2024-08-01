package com.example.todaySpoon.yerin.Service;

import com.example.todaySpoon.yerin.Entity.User;
import com.example.todaySpoon.yerin.dto.UserUpdateDto;
import com.example.todaySpoon.yerin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserUpdateDto getUserByUsername(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        if (temp.isPresent()){
            User user= temp.get();
            UserUpdateDto dto= new UserUpdateDto();
            dto.setUserId(user.getUserId());
            dto.setUserName(user.getUserName());
            dto.setPassword(user.getPassword());
            dto.setGender(user.getGender());
            dto.setEmail(user.getEmail());
            dto.setHeight(user.getHeight());
            dto.setWeight(user.getWeight());
            return dto;
        }
        return null;
    }

    public User updateUser(UserUpdateDto user) {
        Optional<User> temp= userRepository.findById(user.getUserId());
        if(temp.isPresent()){
            User newUser = temp.get();
            newUser.setUserId(user.getUserId());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setUserName(user.getUserName());
            newUser.setHeight(user.getHeight());
            newUser.setWeight(user.getWeight());
            newUser.setAge(user.getAge());
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }

    public User joinUser(UserUpdateDto dto) {
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

    //회원가입시 계산하는 메소드
    private static User getUser(UserUpdateDto dto, double BMR) {
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
        user.setTotalProteinAmount(2.2 * user.getWeight()) ;
        user.setTotalCarbohydrateAmount(user.getCalorie() * 0.5 /4);
        user.setTotalFatAmount(user.getCalorie() * 0.2 / 9);
        user.setCarbohydrateAmount(0);
        user.setProteinAmount(0);
        user.setFatAmount(0);
        return user;
    }
}
