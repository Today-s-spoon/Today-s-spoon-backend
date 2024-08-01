package com.example.todaySpoon.Controller;


import com.example.todaySpoon.Dto.MemberDto;
import com.example.todaySpoon.Dto.SignInDto;
import com.example.todaySpoon.Dto.SignUpDto;
import com.example.todaySpoon.auth.jwt.JwtToken;
import com.example.todaySpoon.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="로그인 회원가입 API",description = "로그인과 회원가입하는 API")
@RequestMapping("/users")
public class MemberController {
    private final UserService userService;

    @Operation(summary = "로그인", description="id와 password로 로그인하고 토큰 반환합니다")
    @PostMapping("/login")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String userId = signInDto.getId();
        String password = signInDto.getPassword();
        JwtToken jwtToken = userService.signIn(userId, password);
        log.info("request userId = {}, password = {}", userId, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }
    @Operation(summary = "회원가입", description="회원가입 합니다.")
    @PostMapping("/sign-up")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto savedMemberDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(savedMemberDto);
    }
}
