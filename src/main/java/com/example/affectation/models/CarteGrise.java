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
public class CarteGrise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String registrationNumber; //Numero d'immatriculation
    private String previousRegistrationNumber; //Numero d'immatriculation precedent
    private String firstCirculation;
    private String firstCirculationInMorroco;
    private String usage;
    private LocalDate registrationExpiryDate;
    private String make; // le nom de marque
    private String model; // le modele
    private String chassisNumber; // Numero de chasis
    private Integer numberOfCylinders ; // nombre de cylindres
    private Integer fiscalHorsepower; // puissance fiscale
    private Integer numberOfSeats; // nombres de places
    private Integer kerbWeight; // poids a vide

    @Enumerated(EnumType.STRING)
    private VehicleType type; // le type

    @Enumerated(EnumType.STRING)
    private VehicleCategory category; // le genre

    @Enumerated(EnumType.STRING)
    private FuelType fuelType; // Type de carburant


    //Appropriate vehicle
    @OneToOne
    private Vehicle vehicle;

}
