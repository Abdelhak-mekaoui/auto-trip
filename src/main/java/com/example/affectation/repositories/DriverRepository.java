package com.example.affectation.repositories;

import com.example.affectation.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d " +
            "LEFT JOIN d.plannedTrips pt " +
            "WHERE ((pt.departureDate > :arrivalDate OR pt.expectedArrivalDate < :departureDate) " +
            "OR (pt.departureDate = :arrivalDate AND pt.expectedArrivalDate = :arrivalDate " +
            "AND (pt.departureTime > :arrivalTime OR pt.expectedArrivalTime < :departureTime)) " +
            "OR (pt.departureDate = :departureDate AND pt.expectedArrivalDate = :departureDate " +
            "AND (pt.departureTime > :arrivalTime OR pt.expectedArrivalTime < :arrivalTime)) " +
            "OR (pt.departureDate < :departureDate AND pt.expectedArrivalDate > :arrivalDate)) "
    )
    List<Driver> getCorrespondingDrivers(
            @Param("departureDate") LocalDate departureDate,
            @Param("departureTime") LocalTime departureTime,
            @Param("arrivalDate") LocalDate arrivalDate,
            @Param("arrivalTime") LocalTime arrivalTime
    );

}
