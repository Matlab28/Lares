package com.example.lares.controller;

import com.example.lares.dto.request.CarRequestDto;
import com.example.lares.dto.response.CarResponseDto;
import com.example.lares.entity.CarEntity;
import com.example.lares.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService service;

//    @CachePut(value = "car", key = "#dto.carYear")
    @PostMapping("/create")
    public String create(@RequestBody CarRequestDto dto) {
        return service.create(dto);
    }


    @GetMapping("/read-all-cars")
    public List<CarResponseDto> readAllCars() {
        return service.readAllData();
    }

//    @PutMapping("/update/{id}")
//    public String update(@PathVariable Long id, @RequestBody CarRequestDto dto) {
//        return service.update(id, dto);
//    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
