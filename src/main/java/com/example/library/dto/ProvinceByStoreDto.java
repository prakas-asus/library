package com.example.library.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public interface ProvinceByStoreDto {
    Long getStoreId();
    String getStoreName();
    String getProvinceName();
}
