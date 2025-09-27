package com.example.library.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.library.repository.StoresRepository;

import lombok.RequiredArgsConstructor;

import com.example.library.dto.ActiveAndNonDeleteDataDto;
import com.example.library.dto.ProvinceByStoreDto;
import com.example.library.dto.WhiteListedStoreDto;
import com.example.library.entity.Stores;

@Service
@RequiredArgsConstructor
public class StoresService {
    private final StoresRepository storeRepo;

    public List<Stores> searchByProvinceName(String province) {
        return storeRepo.findActiveByProvinceNameOrWhitelisted(province);
    }

    public List<ProvinceByStoreDto> searchStoresByProvinces(String province, String store) {
        return storeRepo.findByBranch_Province_NameContainingIgnoreCaseAndNameContainingIgnoreCase(province, store);
    }

    public Page<ActiveAndNonDeleteDataDto> findByActiveTrueAndDeletedFalse(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return storeRepo.findByActiveTrueAndDeletedFalse(pageable);
    }

    public List<WhiteListedStoreDto> findByWhitelisted() {
        return storeRepo.findByWhitelisted();
    }
}
