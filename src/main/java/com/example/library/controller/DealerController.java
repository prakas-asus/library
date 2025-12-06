package com.example.library.controller;

import com.example.library.dto.DealerDto;
import com.example.library.entity.Dealer;
import com.example.library.service.DealerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;

    @GetMapping
    public ResponseEntity<List<DealerDto>> getAllDealers() {
        return new ResponseEntity<>(dealerService.getAllDealers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        return dealerService.getDealerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerService.saveDealer(dealer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @RequestBody Dealer dealer) {
        return dealerService.getDealerById(id)
                .map(existingDealer -> {
                    dealer.setId(id);
                    return ResponseEntity.ok(dealerService.saveDealer(dealer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        if (dealerService.getDealerById(id).isPresent()) {
            dealerService.deleteDealer(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/export/csv")
    public ResponseEntity<byte[]> downloadCsv() {
        List<DealerDto> dealers = dealerService.getAllDealers();
        byte[] csvData = dealerService.exportToCsv(dealers);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData("attachment", "dealers.csv");
        
        return new ResponseEntity<>(csvData, headers, HttpStatus.OK);
    }
}