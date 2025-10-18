package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Keranjang;

public interface KeranjangRepository extends JpaRepository<Keranjang, Long> {}