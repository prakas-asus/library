package com.example.library.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kendaraan")
@Getter
@Setter
public class Kendaraan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaKendaraan;
    private String merk;
    private String model;
    private String tipe;
    private Integer tahun;

    @OneToMany(mappedBy = "kendaraan")
    private List<Sparepart> spareparts = new ArrayList<>();
}
