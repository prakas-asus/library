package com.example.library.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    private LocalDateTime tanggalTransaksi;
    private BigDecimal totalHarga;
    private String status; // pending, dibayar, dikirim, selesai, batal
    private String metodePembayaran;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL)
    private List<TransaksiDetail> detailList = new ArrayList<>();
}
