package com.example.library.controller;

import com.example.library.entity.WilayahDocument;
import com.example.library.service.WilayahDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wilayah")
public class WilayahDocumentController {

    @Autowired
    private WilayahDocumentService wilayahDocumentService;

    @PostMapping
    public ResponseEntity<WilayahDocument> createWilayah(@RequestBody WilayahDocument wilayahDocument) {
        WilayahDocument saved = wilayahDocumentService.save(wilayahDocument);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WilayahDocument> getWilayah(@PathVariable String id) {
        Optional<WilayahDocument> wilayahDocument = wilayahDocumentService.findById(id);
        return wilayahDocument.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<WilayahDocument>> getAllWilayah() {
        List<WilayahDocument> wilayahDocumentList = wilayahDocumentService.findAll();
        return ResponseEntity.ok(wilayahDocumentList);
    }

    @GetMapping("/provinsi/{provinsi}")
    public ResponseEntity<List<WilayahDocument>> searchByProvinsi(@PathVariable String provinsi) {
        List<WilayahDocument> wilayahDocumentList = wilayahDocumentService.searchByProvinsi(provinsi);
        return ResponseEntity.ok(wilayahDocumentList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWilayah(@PathVariable String id) {
        wilayahDocumentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}