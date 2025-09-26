package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.repository.StoresRepository;

import lombok.RequiredArgsConstructor;
import com.example.library.entity.Stores;

@Service
@RequiredArgsConstructor
public class StoresService {
    private final StoresRepository storeRepo;

    public List<Stores> searchByProvinceName(String province) {
        return storeRepo.findActiveByProvinceNameOrWhitelisted(province);
    }
}
