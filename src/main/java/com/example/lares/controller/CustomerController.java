package com.example.lares.controller;

import com.example.lares.dto.request.CustomerRequestDto;
import com.example.lares.dto.response.CustomerResponseDto;
import com.example.lares.entity.CustomerEntity;
import com.example.lares.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/create")
    public String create(@RequestBody CustomerRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping("/read-all-customer")
    public List<CustomerResponseDto> readAllCustomers() {
        return service.readAllCustomers();
    }

    @GetMapping("/read-by-name")
    public List<CustomerEntity> readByName(@RequestParam String name) {
        return service.readByName(name);
    }
}
