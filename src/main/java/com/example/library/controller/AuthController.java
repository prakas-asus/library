package com.example.library.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.config.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {
//     private final UserDetailsService uds;
//     private final PasswordEncoder encoder;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserDetailsService uds, PasswordEncoder encoder, JwtUtil jwtUtil) {
//         this.uds = uds;
//         this.encoder = encoder;
//         this.jwtUtil = jwtUtil;
//     }

//     record AuthRequest(String username, String password) {
//     }

//     record AuthResponse(String token) {
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody AuthRequest req) {
//         try {
//             UserDetails ud = uds.loadUserByUsername(req.username());
//             if (ud == null)
//                 return ResponseEntity.status(401).build();

//             // check password (works for InMemoryUserDetailsManager with encoded password)
//             if (!encoder.matches(req.password(), ud.getPassword())) {
//                 return ResponseEntity.status(401).build();
//             }

//             var token = jwtUtil.generateToken(ud.getUsername(), Map.of("roles", ud.getAuthorities().toString()));
//             return ResponseEntity.ok(new AuthResponse(token));

//         } catch (Exception ex) {
//             return ResponseEntity.status(401).build();
//         }
//     }
// }
