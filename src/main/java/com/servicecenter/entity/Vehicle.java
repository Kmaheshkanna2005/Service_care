package com.servicecenter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleType; // car / bike
    private String brand;
    private String model;
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}