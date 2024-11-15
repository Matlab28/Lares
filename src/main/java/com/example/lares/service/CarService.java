package com.example.lares.service;

import com.example.lares.dto.request.CarRequestDto;
import com.example.lares.dto.response.CarResponseDto;
import com.example.lares.entity.CarEntity;
import com.example.lares.entity.CustomerEntity;
import com.example.lares.repository.CarRepository;
import com.example.lares.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private static final String CAR_CACHE_KEY = "allCars";
    private static final String CAR_CACHE_PREFIX = "car:";
    private final CarRepository repository;
    // Inject RedisTemplate for Redis operations
    private final RedisTemplate<String, Object> redisTemplate;

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public String create(CarRequestDto dto) {
        CarEntity entity = modelMapper.map(dto, CarEntity.class);


        repository.save(entity);
        return "Created";
    }


    public List<CarResponseDto> readAllData() {
        List<CarEntity> all = repository.findAll();

        return all
                .stream()
                .map(m -> modelMapper.map(m, CarResponseDto.class))
                .toList();
    }

    public List<CarResponseDto> readAll() {
        return repository
                .findAll()
                .stream()
                .map(m -> modelMapper.map(m, CarResponseDto.class))
                .collect(Collectors.toList());
    }




//    public String create(CarDto dto) {
//        CarEntity entity = new CarEntity();
//
//        entity.setBrand(dto.getBrand());
//        entity.setModel(dto.getModel());
//        entity.setColor(dto.getColor());
//        entity.setUsed(dto.getUsed());
//        entity.setMotor(dto.getMotor());
//
//        repository.save(entity);
//
//        // Update cache for all cars
//        cacheAllCars();
//        return "Car created successfully";
//    }


//    public List<CarEntity> readAllCars() {
//        List<CarEntity> cars;
//
//        // Check if "all cars" cache is available
//        if (Boolean.TRUE.equals(redisTemplate.hasKey(CAR_CACHE_KEY))) {
//            cars = (List<CarEntity>) redisTemplate.opsForValue().get(CAR_CACHE_KEY);
//        } else {
//            cars = repository.findAll();
//            cacheAllCars();
//        }
//
//        return cars;
//    }


//    public String update(Long id, CarDto dto) {
//        CarEntity entity = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Car not found by ID - " + id));
//
//        entity.setBrand(dto.getBrand());
//        entity.setModel(dto.getModel());
//        entity.setColor(dto.getColor());
//        entity.setUsed(dto.getUsed());
//        entity.setMotor(dto.getMotor());
//
//        cacheCarById(id, entity);
//        cacheAllCars();
//        repository.save(entity);
//        return "Car Updated Successfully!";
//    }

    public String delete(Long id) {
        repository.deleteById(id);

        // Remove specific car cache and update all-cars cache
        redisTemplate.delete(CAR_CACHE_PREFIX + id);
        cacheAllCars();

        return "Car deleted successfully";
    }

    private void cacheAllCars() {
        List<CarEntity> cars = repository.findAll();
        redisTemplate.opsForValue().set(CAR_CACHE_KEY, cars, 10, TimeUnit.MINUTES);
    }

    private void cacheCarById(Long id, CarEntity car) {
        redisTemplate.opsForValue().set(CAR_CACHE_PREFIX + id, car, 10, TimeUnit.MINUTES);
    }
}


//
//import com.example.lares.dto.CarDto;
//import com.example.lares.entity.CarEntity;
//import com.example.lares.repository.CarRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CarService {
//    private final CarRepository carRepository;
//
//    @Cacheable(value = "cars", key = "#id")
//    public String create(CarDto dto) {
//        CarEntity entity = new CarEntity();
//
//        entity.setBrand(dto.getBrand());
//        entity.setModel(dto.getModel());
//        entity.setColor(dto.getColor());
//        entity.setUsed(dto.getUsed());
//        entity.setMotor(dto.getMotor());
//
//        carRepository.save(entity);
//        return "Car created successfully!";
//    }
//
//    public List<CarEntity> readAllCars() {
//        return carRepository.findAll();
//    }
//
//    public CarEntity readCarByID(Long id) {
//        return carRepository
//                .findById(id)
//                .orElseThrow(() -> new RuntimeException("knagiow"));
//    }
//
//    public String update(Long id, CarDto dto) {
//        CarEntity entity = carRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Car not found by ID - " + id));
//
//        entity.setBrand(dto.getBrand());
//        entity.setModel(dto.getModel());
//        entity.setColor(dto.getColor());
//        entity.setUsed(dto.getUsed());
//        entity.setMotor(dto.getMotor());

//        carRepository.save(entity);
//        return "Updated!";
//    }
//
//    public String delete(Long id) {
////        CarEntity entity = carRepository.findById(id).orElseThrow();
////
////        carRepository.delete(entity);
//        carRepository.deleteById(id);
//        return "Deleted!";
//    }
//}
