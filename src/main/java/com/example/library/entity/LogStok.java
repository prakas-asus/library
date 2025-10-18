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
@Table(name = "log_stok")
public class LogStok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sparepart_id")
    private Sparepart sparepart;

    private LocalDateTime tanggalPerubahan;
    private Integer stokSebelum;
    private Integer stokSesudah;
    private String keterangan;
}
