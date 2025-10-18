package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.TransaksiDetail;

public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetail, Long> {}