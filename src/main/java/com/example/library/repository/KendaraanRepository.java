package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Kendaraan;

public interface KendaraanRepository extends JpaRepository<Kendaraan, Long> {}