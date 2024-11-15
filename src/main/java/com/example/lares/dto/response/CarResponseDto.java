package com.example.lares.dto.response;

import com.example.lares.entity.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private Boolean used;
    private Double motor;
}
