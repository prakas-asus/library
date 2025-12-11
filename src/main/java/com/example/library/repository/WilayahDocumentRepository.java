package com.example.library.repository;

import com.example.library.entity.WilayahDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WilayahDocumentRepository extends ElasticsearchRepository<WilayahDocument, String> {
    
    List<WilayahDocument> findByProvinsi(String provinsi);
    List<WilayahDocument> findByProvinsiContaining(String provinsi);
}