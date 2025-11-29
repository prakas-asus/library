package com.example.library.service;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.library.config.JwtUtil;
import com.example.library.dto.UserDto;
import com.example.library.entity.AppUser;
import com.example.library.entity.Session;
import com.example.library.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final SessionService sessionService;
    
    public String registerUserAndPassword(UserDto req) {
        if (userRepo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        AppUser user = new AppUser();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        userRepo.save(user);
        return "User registered";
    }

    public Object generateToken(UserDto req){
         UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        authManager.authenticate(authToken);
        String token = jwtUtil.generateToken(req.getUsername());
        sessionService.createSession(Session.builder().sessionToken(token).build(), userRepo.findByUsername(req.getUsername()).get());
        return Map.of("token", token);
    }
}