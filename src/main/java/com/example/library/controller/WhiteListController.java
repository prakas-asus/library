package com.example.library.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.WhiteListedStoreDto;
import com.example.library.entity.Stores;
import com.example.library.repository.StoresRepository;
import com.example.library.service.StoresService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/whitelist")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class WhiteListController {
    // private final StoresRepository storeRepo;

    private final StoresService storeService;

    @GetMapping("")
    public List<WhiteListedStoreDto> getWhitelistedStores() {
        return storeService.findByWhitelisted();
    }
}
