package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Sparepart;

public interface SparepartRepository extends JpaRepository<Sparepart, Long> {}