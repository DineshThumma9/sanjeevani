package com.sanjeevani.controller;

import com.sanjeevani.model.Location;
import com.sanjeevani.model.Patient;
import com.sanjeevani.service.PatientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
        patientService.create(patient);
        return ResponseEntity.ok("Patient created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id) {
        Patient patient = patientService.getById(new ObjectId(id));
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}/location")
    public ResponseEntity<String> updateLocation(@PathVariable String id, @RequestBody Location location) {
        patientService.updateLocation(new ObjectId(id), location);
        return ResponseEntity.ok("Location updated successfully");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable String id, @RequestBody String status) {
        patientService.updateStatus(new ObjectId(id), status);
        return ResponseEntity.ok("Status updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientService.delete(new ObjectId(id));
        return ResponseEntity.ok("Patient deleted successfully");
    }
}