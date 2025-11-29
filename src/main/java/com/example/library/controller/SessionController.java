package com.example.library.controller;

import com.example.library.entity.Session;
import com.example.library.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateSession(@PathVariable String token) {
        boolean isValid = sessionService.isValidSession(token);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Session>> getActiveSessionsByUser(@PathVariable Long userId) {
        List<Session> sessions = sessionService.getActiveSessionsByUser(userId);
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/invalidate/{token}")
    public ResponseEntity<Void> invalidateSession(@PathVariable String token) {
        sessionService.invalidateSession(token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{token}")
    public ResponseEntity<Session> getSessionByToken(@PathVariable String token) {
        return sessionService.findByToken(token)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}