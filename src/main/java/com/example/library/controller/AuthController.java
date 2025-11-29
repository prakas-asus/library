package com.example.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.library.dto.UserDto;
import com.example.library.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto req) {
        return ResponseEntity.ok(authService.registerUserAndPassword(req));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto req) {
        return ResponseEntity.ok(authService.generateToken(req));
    }
    
}
