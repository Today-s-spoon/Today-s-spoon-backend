package com.example.todaySpoon.controller;


import com.example.todaySpoon.Dto.UserUpdateDto;
import com.example.todaySpoon.Service.YUserService;
import com.example.todaySpoon.entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="마이페이지 API",description = "user의 회원 정보 조회와 정보 수정")
@RequestMapping("api/my")
@RequiredArgsConstructor
public class MyController {

    private final YUserService yUserService;

    @Operation(summary = "user 현재 회원 정보 조회")
    @GetMapping("/{user_id}")
    public UserUpdateDto getUserByUserID(@PathVariable String user_id) {
        return yUserService.getUserByUsername(user_id);
    }

    @Operation(summary = "user 정보 업데이트")
    @PutMapping
    public User updateUser(@RequestBody UserUpdateDto user) {
        return yUserService.updateUser(user);
    }

    // test를 위한 회원가입
    @PostMapping
    public User joinUser (@RequestBody UserUpdateDto user){
        return yUserService.joinUser(user);
    }
}
