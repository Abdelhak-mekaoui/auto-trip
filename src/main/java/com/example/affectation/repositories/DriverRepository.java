package com.example.affectation.entities.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    // You can add custom query methods if needed
    // For example, finding a driver by registration number
    Driver findByRegistrationNumber(String registrationNumber);
}
