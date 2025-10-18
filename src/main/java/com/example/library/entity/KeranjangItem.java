package com.example.library.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "keranjang_item")
public class KeranjangItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "keranjang_id")
    private Keranjang keranjang;

    @ManyToOne
    @JoinColumn(name = "sparepart_id")
    private Sparepart sparepart;

    private Integer kuantitas;
    private BigDecimal subtotal;
}
