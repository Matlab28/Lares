package com.example.lares.dto.response;

import com.example.lares.entity.CarEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private CarEntity car;
//    private CarResponseDto carResponseDto;
}
