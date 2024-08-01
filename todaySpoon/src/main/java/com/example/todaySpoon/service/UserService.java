package com.example.todaySpoon.Service;


import com.example.todaySpoon.Dto.MemberDto;
import com.example.todaySpoon.Dto.SignUpDto;
import com.example.todaySpoon.auth.jwt.JwtToken;
import jakarta.transaction.Transactional;

public interface UserService {
    @Transactional
    JwtToken signIn(String userId, String password);

    @Transactional
    MemberDto signUp(SignUpDto signUpDto);
}
