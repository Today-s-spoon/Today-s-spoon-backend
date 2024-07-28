package com.example.todaySpoon.Service;

import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public User getUserByUsername(String userID) {
        Optional<User> temp= userRepository.findById(userID);
        return temp.orElse(null);
    }

    public User updateUser(User user) {
        Optional<User> temp= userRepository.findById(user.getUserID());
        if(temp.isPresent()){
            User newUser = temp.get();
            newUser.setUserID(user.getUserID());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }
}
