package com.example.library.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.BranchesService;
import com.example.library.service.StoresService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

import com.example.library.entity.Branches;
import com.example.library.entity.Stores;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()") 
public class ApiController {
    private final StoresService storeService;
    private final BranchesService branchService;

    @GetMapping("/stores/search")
    public List<Stores> searchStores(@RequestParam String province) {
        return storeService.searchByProvinceName(province);
    }

    @PutMapping("/branches/{id}")
    public Branches updateBranch(@PathVariable Long id, @RequestBody Branches branch) {
        return branchService.updateBranch(id, branch);
    }

    @DeleteMapping("/branches/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }
}
