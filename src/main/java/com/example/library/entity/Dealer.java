package com.example.library.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "dealer")
@Getter
@Setter
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaDealer;
    private String address;
    private Double latitude;
    private Double longitude;
    private String noTelepon;
    private String email;
    private Double rating;
    private String jamOperasional;

    @ManyToOne
    @JoinColumn(name = "kota_id")
    private Kota kota;

    @ManyToOne
    @JoinColumn(name = "provinsi_id")
    private Provinsi provinsi;

    @OneToMany(mappedBy = "dealer")
    private List<Sparepart> spareparts = new ArrayList<>();
}
