package com.example.library.dto;

import lombok.Data;

@Data
public class DealerDto {
    private Long id;
    private String namaDealer;
    private String address;
    private Double latitude;
    private Double longitude;
    private String noTelepon;
    private String email;
    private Double rating;
    private String jamOperasional;
    private String namaKota;
    private String namaProvinsi;
}