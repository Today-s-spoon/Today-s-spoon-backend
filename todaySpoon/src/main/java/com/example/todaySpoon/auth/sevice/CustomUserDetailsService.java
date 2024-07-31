package com.example.todaySpoon.auth.sevice;

import com.example.todaySpoon.auth.entity.Member;
import com.example.todaySpoon.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        return memberRepository.findById(userid)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }
    private UserDetails createUserDetails(Member member) {
        return User.builder()
                .username(member.getId())
                //signup 완성시 빼기
                .password(member.getPassword())
                .build();
    }
}
