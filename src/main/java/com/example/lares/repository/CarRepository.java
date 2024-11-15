package com.example.lares.repository;

import com.example.lares.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity findByBrandAndModelOrAndUsed(String brand, String model, boolean used);
}
