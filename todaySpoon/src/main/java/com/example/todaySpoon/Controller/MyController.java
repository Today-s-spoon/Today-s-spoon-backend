package com.example.todaySpoon.Controller;

import com.example.todaySpoon.Entity.User;
import com.example.todaySpoon.Service.UserService;
import com.example.todaySpoon.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="마이페이지 API",description = "user의 회원 정보 조회와 정보 수정")
@RequestMapping("/my")
@RequiredArgsConstructor
public class MyController {

    private final UserService userService;

    @Operation(summary = "user 현재 회원 정보 조회")
    @GetMapping("/{user_id}")
    public UserUpdateDto getUserByUserID(@PathVariable String user_id) {
        return userService.getUserByUsername(user_id);
    }

    @Operation(summary = "user 정보 업데이트")
    @PutMapping
    public User updateUser(@RequestBody UserUpdateDto user) {
        return userService.updateUser(user);
    }

    // test를 위한 회원가입
    @PostMapping
    public User joinUser (@RequestBody UserUpdateDto user){
        return userService.joinUser(user);
    }
}
