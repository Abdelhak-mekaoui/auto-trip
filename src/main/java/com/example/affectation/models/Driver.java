package com.example.affectation.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName; // Prenom
    private String lastName; //Nom
    private String registrationNumber; // Matricule
    private LocalDate dateOfBirth; // Date de naissance
    private String nationalId; // CIN

    // Additional fields
    private String contactNumber; // Coordonnées personnelles

    // Enum for skills
    @Enumerated(EnumType.STRING)
    private DriverSkills skills;

    private String drivingExperience;
    private String licenseNumber;

    // Relationships
    @OneToMany(mappedBy = "driver")
    private List<DriverLicense> licenses;

    @OneToMany(mappedBy = "driver")
    private List<Training> trainings;

    @OneToMany(mappedBy = "driver")
    private List<Certification> certifications;

    @OneToMany(mappedBy = "assignedDriver")
    private List<PlannedTrip> plannedTrips;

}
