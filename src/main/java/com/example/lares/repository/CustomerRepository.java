package com.example.lares.repository;

import com.example.lares.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<List<CustomerEntity>> findByFirstNameIgnoreCase(String name);


    boolean existsByEmail(String email);
}
