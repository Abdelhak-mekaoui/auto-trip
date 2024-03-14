package com.example.affectation.dtos;

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
public class PlannedTripRequest {
    private LocalDate departureDate; // Date de depart
    private LocalTime departureTime; // Temps de depart
    private LocalDate expectedArrivalDate; // Date estime d'arrivee
    private LocalTime expectedArrivalTime; // Temps estime d'arrivee
    private String departureLocation; // Lieu de depart
    private String destination; // Lieu destination
    private String requiredVehicleType; // Le type de vehicule demande pour ce voyage
    private int numberOfPassengers; // Nombre de passagers
    private String otherDetails;
}