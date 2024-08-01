package com.example.todaySpoon.controller;


import com.example.todaySpoon.Dto.MemberDto;
import com.example.todaySpoon.Dto.SignInDto;
import com.example.todaySpoon.Dto.SignUpDto;
import com.example.todaySpoon.auth.jwt.JwtToken;
import com.example.todaySpoon.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberController {

    private final UserService userService;

    @PostMapping("/login")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String userId = signInDto.getId();
        String password = signInDto.getPassword();
        JwtToken jwtToken = userService.signIn(userId, password);
        log.info("request userId = {}, password = {}", userId, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto savedMemberDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(savedMemberDto);
    }
}
