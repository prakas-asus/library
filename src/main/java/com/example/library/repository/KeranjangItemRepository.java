package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.KeranjangItem;

public interface KeranjangItemRepository extends JpaRepository<KeranjangItem, Long> {}