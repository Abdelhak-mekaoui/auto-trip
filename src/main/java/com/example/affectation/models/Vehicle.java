package com.example.affectation.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String registrationNumber; // Numéro d'immatriculation
    private String brand; // Marque
    private String model; // Modèle
    private String vehicleType; // Type de véhicule
    private Double mileage; // Kilométrage
    private Boolean availability; // Disponibilité

    private String requiredLicenseType; // Type de permis requis

    // Équipements spéciaux
    private String specialEquipment;

    @OneToOne
    private CarteGrise carteGrise;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleInsurance> insuranceRecords;


    @OneToMany(mappedBy = "assignedVehicle")
    private List<PlannedTrip> plannedTrips;

}
