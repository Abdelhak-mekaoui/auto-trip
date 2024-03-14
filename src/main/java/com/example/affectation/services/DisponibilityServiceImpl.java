package com.example.affectation.services;

import com.example.affectation.models.*;
import com.example.affectation.repositories.*;
import com.example.affectation.services.DisponibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DisponibilityServiceImpl implements DisponibilityService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    VehicleRepository vehicleRepository;


    @Override
    public List<Driver> getCorrespondingDrivers(
            LocalDate departureDate,
            LocalTime departureTime,
            LocalDate arrivalDate,
            LocalTime arrivalTime
    ) {
        if (departureDate.isAfter(arrivalDate) ||
                (departureDate.isEqual(arrivalDate) &&
                        departureTime.isAfter(arrivalTime))) {
            throw new IllegalArgumentException("Departure must be before arrival");
        }
        return driverRepository.getCorrespondingDrivers(departureDate, departureTime, arrivalDate, arrivalTime);
    }

    @Override
    public List<Driver> filterDriversByLicenseType(List<Driver> drivers,
                                                   DriverLicenseType licenseType,
                                                   LocalDate arrivalDate
    ) {

        return drivers.stream()
                .filter(driver -> hasValidLicense(driver, licenseType, arrivalDate))
                .collect(Collectors.toList());
    }


    public List<Driver> getDisponibleDrivers(LocalDate departureDate,
                                             LocalTime departureTime,
                                             LocalDate arrivalDate,
                                             LocalTime arrivalTime,
                                             DriverLicenseType licenseType)
    {
        List<Driver> drivers = getCorrespondingDrivers(departureDate, departureTime, arrivalDate, arrivalTime);
        return filterDriversByLicenseType(drivers, licenseType, arrivalDate);
    }

    private boolean hasValidLicense(Driver driver, DriverLicenseType licenseType, LocalDate arrivalDate) {
        return driver.getLicenses().stream()
                .anyMatch(license -> license.getType() == licenseType &&
                        license.getExpiryDate() != null &&
                        !license.getExpiryDate().isBefore(arrivalDate));
    }

    @Override
    public List<Vehicle> getCorrespondingVehicles(LocalDate deparatureDate,
                                                  LocalTime deparatureTime,
                                                  LocalDate arrivaltDate,
                                                  LocalTime arrivalTime) {
        return null;
    }

}
