package com.example.todaySpoon.auth.constant;

public class JwtConstant {
    // Access Token 만료 시간 (밀리초 단위)
    public static final long ACCESS_TOKEN_EXPIRE_TIME = 3600000; // 1시간 (60분 * 60초 * 1000밀리초)

    // Refresh Token 만료 시간 (밀리초 단위)
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 604800000; // 7일 (7일 * 24시간 * 60분 * 60초 * 1000밀리초)

    // Grant Type
    public static final String GRANT_TYPE = "Bearer";
}
