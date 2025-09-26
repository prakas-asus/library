package com.example.library.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Stores;
import com.example.library.repository.StoresRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/whitelist")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class WhiteListController {
    private final StoresRepository storeRepo;

    @PostMapping("/{storeId}")
    public Stores addWhitelist(@PathVariable Long storeId) {
        Stores s = storeRepo.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store not found"));
        s.setWhitelisted(true);
        return storeRepo.save(s);
    }

    @DeleteMapping("/{storeId}")
    public Stores removeWhitelist(@PathVariable Long storeId) {
        Stores s = storeRepo.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store not found"));
        s.setWhitelisted(false);
        return storeRepo.save(s);
    }
}
