package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {}