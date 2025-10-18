package com.example.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dealer_kendaraan")
@Getter
@Setter
public class DealerKendaraan {

    @Id
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @Id
    @ManyToOne
    @JoinColumn(name = "kendaraan_id")
    private Kendaraan kendaraan;
}
