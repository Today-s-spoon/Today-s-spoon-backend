package com.example.todaySpoon.Service;


import com.example.todaySpoon.Dto.UserUpdateDto;
import com.example.todaySpoon.entity.User;
import com.example.todaySpoon.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class YUserService {
    private final UserRepository userRepository;
    public UserUpdateDto getUserByUsername(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        if (temp.isPresent()){
            User user= temp.get();
            UserUpdateDto dto= new UserUpdateDto();
            dto.setUserId(user.getId());
            dto.setAge(user.getAge());
            dto.setUserName(user.getUsername());
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
            newUser.setId(user.getUserId());
            newUser.setEmail(user.getEmail());
            newUser.setUsername(user.getUserName());
            newUser.setHeight(user.getHeight());
            newUser.setWeight(user.getWeight());
            newUser.setAge(user.getAge());
            newUser= setNut(newUser,user);
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }

    public User setNut(User newUser, UserUpdateDto user){
        double BMR;
        if (user.getGender().equals("Male")){
            BMR= 88.362 + (13.397* user.getWeight()) + (4.799* user.getHeight()) - (5.677 * user.getAge());
        }
        else {
            BMR= 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight()) - (4.330* user.getAge());
        }
        newUser.setCalorie(BMR*1.375);
        newUser.setTotalCarbohydrateAmount(newUser.getCalorie()*0.5/4);
        newUser.setTotalFatAmount(newUser.getCalorie()*0.2/9);
        newUser.setTotalProteinAmount(user.getWeight()*2.2);
        return newUser;
    }

}
