package com.example.lares.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Setter
@Getter
@Table(name = "car_details")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ElementCollection
//    private List<String> brand;
    private String brand;

    @NotEmpty(message = "Model cannot be empty")
    private String model;
    private String color;
    private Boolean used;
    private Double motor;

    @Column(name = "car_year")
    private Integer carYear;


//
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    @JsonIgnore
//    private CustomerEntity customers;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "customer_cars",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id"))
//    private List<CustomerEntity> customerEntities;

    @OneToOne(mappedBy = "carEntity")
    private CustomerEntity customer;
}
