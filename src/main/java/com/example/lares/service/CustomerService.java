package com.example.lares.service;

import com.example.lares.dto.request.CustomerRequestDto;
import com.example.lares.dto.response.CarResponseDto;
import com.example.lares.dto.response.CustomerResponseDto;
import com.example.lares.entity.CarEntity;
import com.example.lares.entity.CustomerEntity;
import com.example.lares.repository.CarRepository;
import com.example.lares.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final ModelMapper modelMapper;
    private final CustomerRepository repository;
    private final CarRepository carRepository;


    public String create(CustomerRequestDto dto) {
        CustomerEntity entity = modelMapper.map(dto, CustomerEntity.class);

        CarEntity car = carRepository.findById(dto.getCarId()).orElseThrow();
        entity.setCarEntity(car);

        repository.save(entity);
        return "Customer created successfully!";
    }

    public List<CustomerResponseDto> readAllCustomers() {
        return repository
                .findAll()
                .stream()
                .map(m -> modelMapper.map(m, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }


    public List<CustomerEntity> readByName(String name) {
        List<CustomerEntity> byFirstNameIgnoreCase = repository
                .findByFirstNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Not found by name - " + name));
        return byFirstNameIgnoreCase;
    }
}
