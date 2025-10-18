package com.example.library.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_request")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @ManyToOne
    @JoinColumn(name = "kendaraan_id")
    private Kendaraan kendaraan;

    private LocalDateTime tanggalService;
    private String deskripsi;
    private String status; // requested, in_progress, completed
}
