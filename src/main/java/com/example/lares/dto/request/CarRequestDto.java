package com.example.lares.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarRequestDto {
    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private Boolean used;
    private Double motor;
}
