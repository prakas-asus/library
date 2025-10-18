package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {}