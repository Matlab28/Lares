package com.example.lares.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "customer_info")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "age")
    private Integer age;

//    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<CarEntity> car;



    
//    @ManyToMany(mappedBy = "customerEntities")
//    private List<CarEntity> carEntities;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @JsonIgnore
    private CarEntity carEntity;
}
