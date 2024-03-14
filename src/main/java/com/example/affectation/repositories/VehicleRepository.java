package com.example.affectation.repositories;



import com.example.affectation.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT DISTINCT v FROM Vehicle v JOIN FETCH v.plannedTrips pt  " +
            "WHERE pt.expectedArrivalDate < :currentDate " +
            "AND pt.expectedArrivalTime < :currentTime " +
            "AND v.requiredLicenseType = :requiredLicenseType " +
            "AND v.license.carteGriseValidity <= :validUntil " +
            "AND v.license.insuranceValidity <= :validUntil " +
            "AND v.license.technicalVisitValidity <= :validUntil"
    )
    List<Vehicle> findVehicles(
            @Param("currentDate") LocalDate currentDate,
            @Param("currentTime") LocalTime currentTime,
            @Param("requiredLicenseType") String requiredLicenseType,
            @Param("validUntil") LocalDate validUntil
    );

}
