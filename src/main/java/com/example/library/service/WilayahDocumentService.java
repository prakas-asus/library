package com.example.library.service;

import com.example.library.entity.WilayahDocument;
import com.example.library.repository.WilayahDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Service
public class WilayahDocumentService {

    @Autowired
    private WilayahDocumentRepository wilayahDocumentRepository;

    public WilayahDocument save(WilayahDocument wilayahDocument) {
        return wilayahDocumentRepository.save(wilayahDocument);
    }

    public Optional<WilayahDocument> findById(String id) {
        return wilayahDocumentRepository.findById(id);
    }

    public List<WilayahDocument> findAll() {
        return StreamSupport.stream(wilayahDocumentRepository.findAll().spliterator(), false)
                           .collect(Collectors.toList());
    }

    public List<WilayahDocument> findByProvinsi(String provinsi) {
        return wilayahDocumentRepository.findByProvinsi(provinsi);
    }

    public List<WilayahDocument> searchByProvinsi(String provinsi) {
        return wilayahDocumentRepository.findByProvinsiContaining(provinsi);
    }

    public void deleteById(String id) {
        wilayahDocumentRepository.deleteById(id);
    }
}