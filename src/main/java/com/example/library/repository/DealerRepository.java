package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {}