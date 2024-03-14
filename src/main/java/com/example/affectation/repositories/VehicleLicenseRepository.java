package com.example.affectation.repositories;

import com.example.affectation.models.VehicleLicense;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VehicleLicenseRepository {
    List<VehicleLicense> findByInsuranceValidityAfterAndTechnicalVisitValidityAfterAndCarteGriseValidityAfter(
            LocalDate insuranceValidity,
            LocalDate technicalVisitValidity,
            LocalDate carteGriseValidity
    );
}
