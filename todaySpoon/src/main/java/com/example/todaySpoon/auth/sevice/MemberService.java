package com.example.todaySpoon.auth.sevice;

import com.example.todaySpoon.auth.jwt.JwtToken;
import jakarta.transaction.Transactional;

public interface MemberService {
    @Transactional
    JwtToken signIn(String userId, String password);
}
