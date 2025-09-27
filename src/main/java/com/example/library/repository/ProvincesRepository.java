package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Provinces;

@Repository
public interface ProvincesRepository extends JpaRepository<Provinces, Long> {
    
}
