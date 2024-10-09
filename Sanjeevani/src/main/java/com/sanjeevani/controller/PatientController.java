package com.sanjeevani.controller;

import com.sanjeevani.entity.Patient;
import com.sanjeevani.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@Slf4j
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
        try {
            patientService.registerPatient(patient);
            log.info("Patient registered: {}", patient.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient registered successfully.");
        } catch (Exception e) {
            log.error("Error registering patient", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error registering patient: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.ok("Patient deleted successfully.");
        } catch (Exception e) {
            log.error("Error deleting patient", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting patient: " + e.getMessage());
        }
    }
}
