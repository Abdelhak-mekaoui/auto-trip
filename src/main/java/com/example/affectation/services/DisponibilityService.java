package com.example.affectation.services;

import com.example.affectation.models.Driver;
import com.example.affectation.models.DriverLicenseType;
import com.example.affectation.models.PlannedTrip;
import com.example.affectation.models.Vehicle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DisponibilityService {
    public List<Driver> getCorrespondingDrivers( LocalDate deparatureDate,
                                                 LocalTime deparatureTime,
                                                 LocalDate arrivaltDate,
                                                 LocalTime arrivalTime
                                                 );
    public List<Vehicle> getCorrespondingVehicles(
            LocalDate departureDate,
            LocalTime departureTime,
            LocalDate arrivalDate,
            LocalTime arrivalTime
    );

    public List<Driver> filterDriversByLicenseType(List<Driver> drivers,
                                                   DriverLicenseType licenseType,
                                                   LocalDate arrivalDate
    );


}
