package com.example.affectation.services;

import com.example.affectation.dtos.PlannedTripRequest;
import com.example.affectation.models.PlannedTrip;
import com.example.affectation.repositories.PlannedTripRepository;
import com.example.affectation.services.DisponibilityService;
import com.example.affectation.services.PlanningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PlanningServiceImpl implements PlanningService {

    @Autowired
    private final DisponibilityService disponibilityService;

    @Autowired
    private final PlannedTripRepository plannedTripRepository;









    @Override
    public PlannedTrip registerTrip(PlannedTripRequest plannedTripRequest) {
        // Check if departure is before arrival
        if (plannedTripRequest.getDepartureDate().isAfter(plannedTripRequest.getExpectedArrivalDate()) ||
                (plannedTripRequest.getDepartureDate().isEqual(plannedTripRequest.getExpectedArrivalDate()) &&
                        plannedTripRequest.getDepartureTime().isAfter(plannedTripRequest.getExpectedArrivalTime()))) {
            throw new IllegalArgumentException("Departure must be before arrival");
        }

        // Convert DTO to PlannedTrip entity
        PlannedTrip plannedTrip = PlannedTrip.builder()
                .departureDate(plannedTripRequest.getDepartureDate())
                .departureTime(plannedTripRequest.getDepartureTime())
                .expectedArrivalDate(plannedTripRequest.getExpectedArrivalDate())
                .expectedArrivalTime(plannedTripRequest.getExpectedArrivalTime())
                .departureLocation(plannedTripRequest.getDepartureLocation())
                .destination(plannedTripRequest.getDestination())
                .requiredVehicleType(plannedTripRequest.getRequiredVehicleType())
                .numberOfPassengers(plannedTripRequest.getNumberOfPassengers())
                .otherDetails(plannedTripRequest.getOtherDetails())
                .build();

        // Add any additional business logic or validation here before saving to the repository
        return plannedTripRepository.save(plannedTrip);
    }



}
