package com.example.library.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;

    @Data
    public static class RatingDto {
        private Double rate;
        private Integer count;
    }
}