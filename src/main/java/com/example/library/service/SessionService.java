package com.example.library.service;

import com.example.library.entity.AppUser;
import com.example.library.entity.Session;
import com.example.library.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Optional<Session> findByToken(String token) {
        return sessionRepository.findBySessionToken(token);
    }

    public List<Session> getActiveSessionsByUser(Long userId) {
        return sessionRepository.findByUserIdAndActiveTrue(userId);
    }

    public void createSession(Session session, AppUser user) {
        session.setUser(user);
        session.setCreatedAt(LocalDateTime.now());
        session.setExpiresAt(LocalDateTime.now().plusHours(24));
        session.setActive(true);
        session.setSessionToken(session.getSessionToken());
        sessionRepository.save(session);
    }

    @Transactional
    public void invalidateSession(String token) {
        sessionRepository.findBySessionToken(token)
                .ifPresent(session -> {
                    session.setActive(false);
                    sessionRepository.save(session);
                });
    }

    public boolean isValidSession(String token) {
        return !sessionRepository.findBySessionToken(token).get().getSessionToken().isEmpty() && token != null ? true : false;
    }
}