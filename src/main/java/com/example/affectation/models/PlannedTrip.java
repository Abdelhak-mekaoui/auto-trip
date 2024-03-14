package com.example.affectation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlannedTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Identifiant unique

    private LocalDate departureDate; // Date de depart
    private LocalTime departureTime; // Temps de depart
    private LocalDate expectedArrivalDate; // Date estime d'arrivee
    private LocalTime expectedArrivalTime; // Temps estime d'arrivee
    private String departureLocation; // Lieu de depart
    private String destination; // Lieu destination
    private String requiredVehicleType; // Le type de vehicule demande pour ce voyage
    private int numberOfPassengers; // Nombre de passagers
    private String otherDetails; // Autre details

    @ManyToOne
    private Vehicle assignedVehicle; // The vehicle assigned to this planned trip

    @ManyToOne
    private Driver assignedDriver; // The driver assigned to this planned trip
}