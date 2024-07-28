package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userID}")
    public User getUserByUserID(@PathVariable String userID) {
        return userService.getUserByUsername(userID);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
