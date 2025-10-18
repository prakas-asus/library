package com.example.library.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sparepart")
@Getter
@Setter
public class Sparepart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaSparepart;
    private String kodeSparepart;
    private String deskripsi;
    private BigDecimal harga;
    private Integer stok;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @ManyToOne
    @JoinColumn(name = "kendaraan_id")
    private Kendaraan kendaraan;
}
