package com.sanjeevani.controller;

import com.sanjeevani.model.Ambulance;
import com.sanjeevani.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

@RestController
@RequestMapping("/ambulance")
public class AmbulanceController {

    @Autowired
    private AmbulanceService ambulanceService;

    @GetMapping
    public List<Ambulance> getAmbulance() {
        return ambulanceService.getAmbulance();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Ambulance ambulance) {
        try {
            ambulanceService.create(ambulance);
            return new ResponseEntity<>("Ambulance created successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ambulance creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @PutMapping
//    public ResponseEntity<String> update(@RequestParam String id, @RequestBody Ambulance ambulance) {
//        try {
//            ambulanceService.update(ambulance);
//            return new ResponseEntity<>("Ambulance updated successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Ambulance updation failed", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam ObjectId id) {
        try {
            ambulanceService.delete(id);
            return new ResponseEntity<>("Ambulance deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ambulance deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}