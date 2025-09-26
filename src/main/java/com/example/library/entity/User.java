package com.example.library.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Username harus 3-50 karakter")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Nama harus 3-50 karakter")
    @Column(nullable = false)
    private String nama;

    @NotNull(message = "Tanggal lahir tidak boleh kosong")
    @Past(message = "Tanggal lahir harus di masa lalu")
    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;

    @NotBlank(message = "Address tidak boleh kosong")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;
}
