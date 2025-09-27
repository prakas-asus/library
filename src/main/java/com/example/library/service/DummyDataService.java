package com.example.library.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.Branches;
import com.example.library.entity.Provinces;
import com.example.library.entity.Stores;
import com.example.library.repository.BranchesRepository;
import com.example.library.repository.ProvincesRepository;
import com.example.library.repository.StoresRepository;

import jakarta.annotation.PostConstruct;

@Service
public class DummyDataService {
    @Autowired
    private BranchesRepository branchRepo;

    @Autowired
    private StoresRepository storesRepository;

    @Autowired
    private ProvincesRepository provincesRepository;

    // @PostConstruct
    // public void createDummyData() {

    //     // --- Cek apakah sudah pernah di-seed ---
    //     if (provincesRepository.count() > 0 || branchRepo.count() > 0 ||
    //             storesRepository.count() > 0) {
    //         return; // sudah ada data -> jangan duplicate
    //     }

    //     // === 1. List provinsi Indonesia ===
    //     List<String> provinceNames = Arrays.asList(
    //             "Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Kepulauan Riau", "Jambi", "Bengkulu",
    //             "Sumatera Selatan", "Lampung", "Bangka Belitung", "DKI Jakarta", "Jawa Barat", "Banten",
    //             "Jawa Tengah", "DI Yogyakarta", "Jawa Timur", "Bali", "Nusa Tenggara Barat",
    //             "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Tengah", "Kalimantan Selatan",
    //             "Kalimantan Timur", "Kalimantan Utara", "Sulawesi Utara", "Sulawesi Tengah",
    //             "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Maluku", "Maluku Utara",
    //             "Papua", "Papua Barat", "Papua Tengah", "Papua Pegunungan", "Papua Selatan",
    //             "Papua Barat Daya");

    //     // === 2. Simpan Provinces ===
    //     List<Provinces> provinces = provinceNames.stream().map(name -> {
    //         Provinces p = new Provinces();
    //         p.setName(name);
    //         return p;
    //     }).collect(Collectors.toList());
    //     provincesRepository.saveAll(provinces);

    //     // === 3. Buat ±100 Branches total, dibagi rata ke semua provinsi ===
    //     int totalBranches = 100;
    //     Random random = new Random();
    //     List<Branches> allBranches = new ArrayList<>();

    //     for (int i = 1; i <= totalBranches; i++) {
    //         Branches b = new Branches();
    //         b.setName("Branch " + i);
    //         b.setActive(true);
    //         b.setDeleted(false);
    //         // acak province
    //         b.setProvince(provinces.get(random.nextInt(provinces.size())));
    //         allBranches.add(b);
    //     }
    //     branchRepo.saveAll(allBranches);

    //     // === 4. Buat ±20.000 Stores, sebar ke semua branches secara merata ===
    //     int totalStores = 1_000;
    //     List<Stores> allStores = new ArrayList<>(totalStores);

    //     for (int i = 1; i <= totalStores; i++) {
    //         Stores s = new Stores();
    //         s.setName("Store " + i);
    //         s.setActive(true);
    //         s.setWhitelisted(i % 50 == 0); // contoh: tiap 50 store di-whitelist
    //         // assign branch secara round robin
    //         s.setBranch(allBranches.get(i % allBranches.size()));
    //         allStores.add(s);

    //         // batch insert setiap 1000 agar memory aman
    //         if (i % 1000 == 0) {
    //             storesRepository.saveAll(allStores);
    //             allStores.clear();
    //         }
    //     }
    //     if (!allStores.isEmpty()) {
    //         storesRepository.saveAll(allStores);
    //     }
    // }

    // @PostConstruct
    // public void createDummyData() {

    // if (provincesRepository.count() > 0 || branchRepo.count() > 0 ||
    // storesRepository.count() > 0) {
    // return; // sudah ada data -> jangan duplicate
    // }

    // List<String> provinceNames = Arrays.asList(
    // "Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Kepulauan Riau",
    // "Jambi", "Bengkulu",
    // "Sumatera Selatan", "Lampung", "Bangka Belitung", "DKI Jakarta", "Jawa
    // Barat", "Banten",
    // "Jawa Tengah", "DI Yogyakarta", "Jawa Timur", "Bali", "Nusa Tenggara Barat",
    // "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Tengah", "Kalimantan
    // Selatan",
    // "Kalimantan Timur", "Kalimantan Utara", "Sulawesi Utara", "Sulawesi Tengah",
    // "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Maluku", "Maluku
    // Utara",
    // "Papua", "Papua Barat", "Papua Tengah", "Papua Pegunungan", "Papua Selatan",
    // "Papua Barat Daya");

    // // Simpan Provinces
    // List<Provinces> provinces = provinceNames.stream().map(name -> {
    // Provinces p = new Provinces();
    // p.setName(name);
    // return p;
    // }).collect(Collectors.toList());
    // provincesRepository.saveAll(provinces);

    // // Buat ~100 Branches total (tetap 100 supaya distribusi merata)
    // int totalBranches = 100;
    // Random random = new Random();
    // List<Branches> allBranches = new ArrayList<>();

    // for (int i = 1; i <= totalBranches; i++) {
    // Branches b = new Branches();
    // b.setName("Branch " + i);
    // b.setActive(true);
    // b.setDeleted(false);
    // b.setProvince(provinces.get(random.nextInt(provinces.size())));
    // allBranches.add(b);
    // }
    // branchRepo.saveAll(allBranches);

    // // === UBAH BAGIAN INI ===
    // // Hanya 100 store untuk percobaan
    // int totalStores = 100;
    // List<Stores> allStores = new ArrayList<>(totalStores);

    // for (int i = 1; i <= totalStores; i++) {
    // Stores s = new Stores();
    // s.setName("Store " + i);
    // s.setActive(true);
    // s.setWhitelisted(i % 10 == 0); // misal tiap 10 store di-whitelist
    // // round-robin ke branch agar tetap tersebar
    // s.setBranch(allBranches.get(i % allBranches.size()));
    // allStores.add(s);
    // }
    // storesRepository.saveAll(allStores);
    // }

    // @PostConstruct
    // public void createDummyData() {
    // // Membuat data dummy untuk Provinces
    // Provinces province1 = new Provinces();
    // province1.setName("Province A");
    // provincesRepository.save(province1);

    // Provinces province2 = new Provinces();
    // province2.setName("Province B");
    // provincesRepository.save(province2);

    // // Membuat data dummy untuk Branches
    // for (int i = 1; i <= 5; i++) {
    // Branches branch = new Branches();
    // branch.setName("Branch " + i);
    // branch.setActive(true);
    // branch.setDeleted(false);
    // branch.setProvince(i % 2 == 0 ? province1 : province2); // Alternate
    // // provinces
    // branchRepo.save(branch);
    // }

    // // Membuat data dummy untuk Stores
    // for (int i = 1; i <= 10; i++) {
    // Stores store = new Stores();
    // store.setName("Store " + i);
    // store.setActive(true);
    // store.setWhitelisted(i % 3 == 0); // Every third store is whitelisted
    // store.setBranch(branchRepo.findById((long) ((i % 5) + 1)).orElse(null)); //
    // // Assign branches in a round-robin fashion
    // storesRepository.save(store);
    // }
    // }
}
