package com.example.library.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Data;
import java.util.List;

@Data
@Document(indexName = "wilayah")
public class WilayahDocument {
    
    @Id
    private String id;
    
    @Field(type = FieldType.Keyword)
    private String provinsi;
    
    @Field(type = FieldType.Nested)
    private List<KabupatenKota> kabupatenKota;
    
    @Data
    public static class KabupatenKota {
        @Field(type = FieldType.Keyword)
        private String nama;
        
        @Field(type = FieldType.Keyword)
        private String kecamatan;
    }
}