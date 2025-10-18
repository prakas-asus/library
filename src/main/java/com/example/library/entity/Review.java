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
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = true)
    private Dealer dealer;

    @ManyToOne
    @JoinColumn(name = "sparepart_id", nullable = true)
    private Sparepart sparepart;

    private Integer rating;
    private String komentar;
    private LocalDateTime tanggal;
}
