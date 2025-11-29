package com.example.library.repository;

import com.example.library.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findBySessionToken(String sessionToken);
    List<Session> findByUserIdAndActiveTrue(Long userId);
    void deleteBySessionToken(String sessionToken);
}