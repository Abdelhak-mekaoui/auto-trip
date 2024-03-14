package com.example.affectation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DriverLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;  // Assuming you have a Driver entity

    @Enumerated(EnumType.STRING)
    private DriverLicenseType type;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String issuingAuthority;


}