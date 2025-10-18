package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {}