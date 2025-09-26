package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.entity.User;

@Repository
public interface UserReposiory extends JpaRepository<User, Long> {
    java.util.Optional<User> findByUsername(String username);
}
