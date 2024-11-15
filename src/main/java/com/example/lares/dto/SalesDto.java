package com.example.lares.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalesDto {
    private String productName;
    private Double salesAmount;

    public SalesDto(String productName, Double salesAmount) {
        this.productName = productName;
        this.salesAmount = salesAmount;
    }
}
