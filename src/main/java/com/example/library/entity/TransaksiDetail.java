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

@Getter
@Setter
@Entity
@Table(name = "transaksi_detail")
public class TransaksiDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "sparepart_id")
    private Sparepart sparepart;

    private Integer kuantitas;
    private BigDecimal hargaSatuan;
    private BigDecimal subtotal;
}
