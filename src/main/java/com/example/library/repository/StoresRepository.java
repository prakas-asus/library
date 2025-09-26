package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long> {
     @Query(nativeQuery = true, value = "SELECT s FROM Store s " +
           "WHERE s.active=true AND s.deleted=false " +
           "AND (LOWER(s.branch.province.name) LIKE LOWER(CONCAT('%', :provinceName, '%')) " +
           "     OR s.whitelisted=true)")
    List<Stores> findActiveByProvinceNameOrWhitelisted(@Param("provinceName") String provinceName);
}
