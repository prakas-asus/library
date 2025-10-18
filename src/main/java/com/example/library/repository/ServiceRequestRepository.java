package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {}