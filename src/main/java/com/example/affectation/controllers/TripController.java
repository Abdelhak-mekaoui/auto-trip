package com.example.affectation.controllers;

import com.example.affectation.dtos.PlannedTripRequest;
import com.example.affectation.services.PlanningService;
import com.example.affectation.services.PlanningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {


    private final PlanningService planningService;

    @Autowired
    public TripController(PlanningService planningService) {
        this.planningService = planningService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerTrip(@RequestBody PlannedTripRequest plannedTripRequest) {
        try {
            planningService.registerTrip(plannedTripRequest);
            return new ResponseEntity<>("Trip registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
