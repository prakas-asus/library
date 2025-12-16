package com.example.library.service;

import com.example.library.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<ProductDto> getAllProducts() {
        ProductDto[] products = restTemplate.getForObject(fakeStoreApiUrl, ProductDto[].class);
        return Arrays.asList(products != null ? products : new ProductDto[0]);
    }
}