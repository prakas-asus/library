package com.example.library.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Username harus 3-50 karakter")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;
    
    private String nama;
    private String email;
    private String address;
    private Double latitude;
    private Double longitude;
    private String noHp;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Provinsi provinsi;

    @ManyToOne
    @JoinColumn(name = "kota_id")
    private Kota kota;

    @OneToMany(mappedBy = "user")
    private List<Transaksi> transaksiList = new ArrayList<>();
}
