package com.example.library.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.library.entity.AppUser;
import com.example.library.entity.Dealer;
import com.example.library.entity.Kendaraan;
import com.example.library.entity.Kota;
import com.example.library.entity.LogStok;
import com.example.library.entity.Provinsi;
import com.example.library.entity.Review;
import com.example.library.entity.ServiceRequest;
import com.example.library.entity.Shipping;
import com.example.library.entity.Sparepart;
import com.example.library.entity.Transaksi;
import com.example.library.entity.TransaksiDetail;
import com.example.library.repository.DealerRepository;
import com.example.library.repository.KendaraanRepository;
import com.example.library.repository.KeranjangItemRepository;
import com.example.library.repository.KeranjangRepository;
import com.example.library.repository.KotaRepository;
import com.example.library.repository.LogStokRepository;
import com.example.library.repository.ProvinsiRepository;
import com.example.library.repository.ReviewRepository;
import com.example.library.repository.ServiceRequestRepository;
import com.example.library.repository.ShippingRepository;
import com.example.library.repository.SparepartRepository;
import com.example.library.repository.TransaksiDetailRepository;
import com.example.library.repository.TransaksiRepository;
import com.example.library.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DummyDataService {

    // private final ProvinsiRepository provinsiRepository;
    private final KotaRepository kotaRepository;
    private final DealerRepository dealerRepository;
    private final KendaraanRepository kendaraanRepository;
    private final SparepartRepository sparepartRepository;
    private final UserRepository userRepository;
    private final ServiceRequestRepository serviceRequestRepository;
    private final ReviewRepository reviewRepository;
    private final ShippingRepository shippingRepository;
    private final LogStokRepository logStokRepository;
    private final TransaksiRepository transaksiRepository;
    private final TransaksiDetailRepository transaksiDetailRepository;
    private final KeranjangRepository keranjangRepository;
    private final ProvinsiRepository provinsiRepository;
    private final KeranjangItemRepository keranjangItemRepository;
    private final PasswordEncoder encoder;

    @PostConstruct
    public void createDummyData() {
        // 🔹 1. Buat daftar provinsi (10 contoh)
        String[] provinceNames = {
                "Jawa Barat", "Jawa Tengah", "Jawa Timur", "DKI Jakarta", "Banten",
                "Sumatera Utara", "Sulawesi Selatan", "Kalimantan Timur", "Bali", "Papua"
        };

        List<Provinsi> provinsiList = new ArrayList<>();
        for (String name : provinceNames) {
            Provinsi p = new Provinsi();
            p.setNamaProvinsi(name);
            provinsiRepository.save(p);
            provinsiList.add(p);
        }

        // 🔹 2. Buat 100 kota
        List<Kota> kotaList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Kota k = new Kota();
            k.setNamaKota("Kota " + i);
            k.setProvinsi(provinsiList.get(i % provinsiList.size()));
            kotaRepository.save(k);
            kotaList.add(k);
        }

        // 🔹 3. Buat 100 dealer
        List<Dealer> dealerList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Dealer d = new Dealer();
            d.setNamaDealer("Dealer " + i);
            d.setAddress("Jl. Contoh No. " + i);
            d.setLatitude(-6.2 + (Math.random() * 2));
            d.setLongitude(106.8 + (Math.random() * 2));
            d.setNoTelepon("0812" + (100000 + i));
            d.setEmail("dealer" + i + "@mail.com");
            d.setRating(3.0 + (Math.random() * 2));
            d.setJamOperasional("08:00 - 17:00");
            d.setKota(kotaList.get(i % kotaList.size()));
            d.setProvinsi(provinsiList.get(i % provinsiList.size()));
            dealerRepository.save(d);
            dealerList.add(d);
        }

        // 🔹 4. Buat 100 kendaraan
        List<Kendaraan> kendaraanList = new ArrayList<>();
        String[] merkList = {"Toyota", "Honda", "Yamaha", "Suzuki", "Mitsubishi", "Kawasaki"};
        String[] tipeList = {"Mobil", "Motor", "Truck", "Bus", "Kapal", "Traktor"};
        for (int i = 1; i <= 100; i++) {
            Kendaraan k = new Kendaraan();
            k.setNamaKendaraan("Kendaraan " + i);
            k.setMerk(merkList[i % merkList.length]);
            k.setModel("Model-" + i);
            k.setTipe(tipeList[i % tipeList.length]);
            k.setTahun(2010 + (i % 15));
            kendaraanRepository.save(k);
            kendaraanList.add(k);
        }

        // 🔹 5. Buat 100 user
        List<AppUser> userList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            AppUser u = new AppUser();
            u.setNama("User " + i);
            u.setUsername("user" + i);
            u.setEmail("user" + i + "@mail.com");
            u.setPassword(encoder.encode("password" + i));
            u.setAddress("Alamat User " + i);
            u.setLatitude(-6.9 + (Math.random() * 1));
            u.setLongitude(107.6 + (Math.random() * 1));
            u.setNoHp("0813" + (100000 + i));
            u.setKota(kotaList.get(i % kotaList.size()));
            u.setProvinsi(provinsiList.get(i % provinsiList.size()));
            userRepository.save(u);
            userList.add(u);
        }

        // 🔹 6. Buat 100 sparepart
        List<Sparepart> sparepartList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Sparepart s = new Sparepart();
            s.setNamaSparepart("Sparepart " + i);
            s.setKodeSparepart("SP-" + i);
            s.setDeskripsi("Sparepart untuk kendaraan tipe " + kendaraanList.get(i % kendaraanList.size()).getTipe());
            s.setHarga(BigDecimal.valueOf(50000 + (i * 1000)));
            s.setStok(100 + i);
            s.setDealer(dealerList.get(i % dealerList.size()));
            s.setKendaraan(kendaraanList.get(i % kendaraanList.size()));
            sparepartRepository.save(s);
            sparepartList.add(s);
        }

        // 🔹 7. Buat 100 transaksi + detail
        for (int i = 1; i <= 100; i++) {
            Transaksi t = new Transaksi();
            t.setUser(userList.get(i % userList.size()));
            t.setTanggalTransaksi(LocalDateTime.now().minusDays(i % 30));
            t.setTotalHarga(BigDecimal.valueOf(500000 + (i * 1000)));
            t.setStatus("selesai");
            t.setMetodePembayaran("Transfer Bank");
            transaksiRepository.save(t);

            TransaksiDetail td = new TransaksiDetail();
            td.setTransaksi(t);
            td.setSparepart(sparepartList.get(i % sparepartList.size()));
            td.setKuantitas(2);
            td.setHargaSatuan(sparepartList.get(i % sparepartList.size()).getHarga());
            td.setSubtotal(sparepartList.get(i % sparepartList.size()).getHarga().multiply(BigDecimal.valueOf(2)));
            transaksiDetailRepository.save(td);

            // Shipping data
            Shipping sh = new Shipping();
            sh.setTransaksi(t);
            sh.setKurir("JNE");
            sh.setNomorResi("RESI" + i);
            sh.setStatusPengiriman("dikirim");
            sh.setTanggalKirim(LocalDateTime.now());
            shippingRepository.save(sh);
        }

        // 🔹 8. Buat 100 Service Request
        for (int i = 1; i <= 100; i++) {
            ServiceRequest sr = new ServiceRequest();
            sr.setUser(userList.get(i % userList.size()));
            sr.setDealer(dealerList.get(i % dealerList.size()));
            sr.setKendaraan(kendaraanList.get(i % kendaraanList.size()));
            sr.setTanggalService(LocalDateTime.now().minusDays(i));
            sr.setDeskripsi("Servis rutin kendaraan");
            sr.setStatus("completed");
            serviceRequestRepository.save(sr);
        }

        // 🔹 9. Buat 100 Review
        for (int i = 1; i <= 100; i++) {
            Review r = new Review();
            r.setUser(userList.get(i % userList.size()));
            r.setDealer(dealerList.get(i % dealerList.size()));
            r.setRating((int) (3 + (Math.random() * 2)));
            r.setKomentar("Review ke-" + i);
            r.setTanggal(LocalDateTime.now());
            reviewRepository.save(r);
        }

        // 🔹 10. Log stok perubahan
        for (Sparepart s : sparepartList) {
            LogStok log = new LogStok();
            log.setSparepart(s);
            log.setTanggalPerubahan(LocalDateTime.now());
            log.setStokSebelum(s.getStok());
            log.setStokSesudah(s.getStok() - 1);
            log.setKeterangan("Penyesuaian stok otomatis");
            logStokRepository.save(log);
        }

        System.out.println("✅ Dummy data berhasil dibuat!");
    }

}
