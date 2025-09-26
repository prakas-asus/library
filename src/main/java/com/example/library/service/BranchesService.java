package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.entity.Branches;
import com.example.library.repository.BranchesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchesService {
     private final BranchesRepository branchRepo;

    public Branches updateBranch(Long id, Branches update) {
        Branches b = branchRepo.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Branch not found"));
        b.setName(update.getName());
        // update properti lain
        return branchRepo.save(b);
    }

    public void deleteBranch(Long id) {
        Branches b = branchRepo.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Branch not found"));
        b.setDeleted(true);       // soft delete
        branchRepo.save(b);
    }
}
