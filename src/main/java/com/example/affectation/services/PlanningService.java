package com.example.affectation.services;

import com.example.affectation.dtos.PlannedTripRequest;
import com.example.affectation.models.Driver;
import com.example.affectation.models.PlannedTrip;
import com.example.affectation.models.Vehicle;

import java.time.LocalDate;


// Service d'affectation

public interface PlanningService {

    public PlannedTrip registerTrip(PlannedTripRequest plannedTripDTO);

}
