package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Service.UserService;
import com.example.todaySpoon.dto.UserCreateDto;
import com.example.todaySpoon.dto.UserResponeDto;
import com.example.todaySpoon.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{user_id}")
    public User getUserByUserID(@PathVariable String user_id) {
        return userService.getUserByUsername(user_id);
    }

    @PutMapping
    public User updateUser(@RequestBody UserUpdateDto user) {
        return userService.updateUser(user);
    }

    @PostMapping
    public User joinUser (@RequestBody UserCreateDto user){
        return userService.joinUser(user);
    }
}
