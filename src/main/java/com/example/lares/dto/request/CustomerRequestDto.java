package com.example.lares.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Long carId;
}
