package com.example.todaySpoon.auth.sevice;

import com.example.todaySpoon.auth.dto.MemberDto;
import com.example.todaySpoon.auth.dto.SignUpDto;
import com.example.todaySpoon.auth.jwt.JwtToken;
import jakarta.transaction.Transactional;

public interface MemberService {
    @Transactional
    JwtToken signIn(String userId, String password);

    @Transactional
    MemberDto signUp(SignUpDto signUpDto);
}
