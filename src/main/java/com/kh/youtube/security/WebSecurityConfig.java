package com.kh.youtube.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.authorizeHttpRequests();

        http.cors()
                .and()
                .csrf().disable()  // jwt 토큰 만들어 뒀기 때문에 disable 함
                .httpBasic().disable() // 위와 동일
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 토큰 방식으로 인증을 하기 때문에 session 방식 막아 놓음
                .and()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                .anyRequest().authenticated();
        
        // JWT 토큰 생성부터 필터처리까지 전부 세팅
        // JWT 필터 등록
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);

        return http.build();
    }
}
