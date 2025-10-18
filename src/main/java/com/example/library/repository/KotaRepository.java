package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Kota;

public interface KotaRepository extends JpaRepository<Kota, Long> {}