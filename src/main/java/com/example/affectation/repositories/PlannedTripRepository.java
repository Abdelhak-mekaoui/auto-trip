package com.example.affectation.repositories;

import com.example.affectation.models.Driver;
import com.example.affectation.models.PlannedTrip;
import com.example.affectation.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PlannedTripRepository extends JpaRepository<PlannedTrip, Integer> {
    List<PlannedTrip> findByAssignedDriverAndAssignedVehicle(Driver driver, Vehicle vehicle);

}
