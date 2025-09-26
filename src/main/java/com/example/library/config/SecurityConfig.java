package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    // .csrf(csrf -> csrf.disable())
    // .authorizeHttpRequests(auth -> auth
    // .requestMatchers("/swagger-ui.html", "/swagger-ui/**",
    // "/v3/api-docs/**").permitAll()
    // .anyRequest().authenticated()
    // )
    // .httpBasic()
    // .and()
    // .sessionManagement(session -> session
    // .sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)
    // );
    // return http.build();
    // }

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // Demo in-memory user. Replace with your own UserDetailsService that loads from
        // DB.
        var user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(UserDetailsService uds) {
        return new JwtAuthenticationFilter(jwtUtil, uds);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // permit swagger and auth endpoints
                        // .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/api/auth/**")
                        // .permitAll()
                        // .anyRequest().authenticated()
                        // untuk sementara di izinkan semua
                        .anyRequest().permitAll()
                        )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}