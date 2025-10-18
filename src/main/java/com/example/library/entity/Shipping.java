package com.example.library.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transaksi_id")
    private Transaksi transaksi;

    private String kurir;
    private String nomorResi;
    private String statusPengiriman; // dikirim, dalam perjalanan, sampai
    private LocalDateTime tanggalKirim;
    private LocalDateTime tanggalTerima;
}

